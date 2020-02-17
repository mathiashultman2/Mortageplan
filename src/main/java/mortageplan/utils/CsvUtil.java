package mortageplan.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import mortageplan.Constants;

public class CsvUtil {

	private final MathUtil mathUtil;

	public CsvUtil(MathUtil mathUtil) {
		this.mathUtil = mathUtil;
	}

	public List<String> filterForCsvLines(List<String> lines) {
		List<String> relevantCsvLines = new ArrayList<>();
		lines.stream().forEach(line -> {
			Optional<String> csvLine = checkIfLineHasNumberOfCommas(line);
			csvLine.ifPresent(relevantCsvLines::add);
		});
		return relevantCsvLines;
	}

	public Optional<String> checkIfLineHasNumberOfCommas(String line) {
		String[] lineSplitByComma = line.split(",");
		if (Constants.CSV_MIN_NUMBER_OF_FIELDS <= lineSplitByComma.length
				&& lineSplitByComma.length <= Constants.CSV_MAX_NUMBER_OF_FIELDS) {
			return Optional.of(line);
		}
		return Optional.empty();
	}

	public void processLine(String line, int index) {
		String[] splitByComma = line.split(",");
		String customer = splitByComma[0];
		double totalLoan = Double.parseDouble(splitByComma[1]);
		double interest = Double.parseDouble(splitByComma[2]);
		int years = Integer.parseInt(splitByComma[3]);
		NumberFormat numberFormat = new DecimalFormat("#,###.00");
		String result = String.format(
				"Prospect %d: %s wants to borrow %s € for a period of %d years and pay %s € each month",
				index, customer, numberFormat.format(totalLoan), years,
				numberFormat.format(this.mathUtil.calculateMonthlyPayment(totalLoan, interest, years * 12)));
		System.out.println(result);
	}

	public String cleanCsvLineOfQuotes(String line) {
		if (line.matches("\".*\".*")) {
			String[] lineSplitByQuotation = line.split("\"");
			lineSplitByQuotation[1] = lineSplitByQuotation[1].replace(",", " ");
			return String.format("%s%s", lineSplitByQuotation[1], lineSplitByQuotation[2]);
		}
		return line;
	}
}
