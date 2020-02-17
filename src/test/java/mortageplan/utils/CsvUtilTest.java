package mortageplan.utils;

import java.util.List;
import java.util.Optional;

import org.junit.Test;

import static org.junit.Assert.*;

public class CsvUtilTest {

	private final CsvUtil csvUtil = new CsvUtil(new MathUtil());

	private static final String LINE_WITH_CORRECT_COMMAS = "Juha,1000,5,2";
	private static final String LINE_WITH_INCORRECT_COMMAS = "Juha1000,5,2";
	private static final String LINE_2_WITH_CORRECT_COMMAS = "Karvinen,4356,1.27,6";
	private static final List<String> LIST_OF_2 = List.of(LINE_WITH_CORRECT_COMMAS,
			LINE_2_WITH_CORRECT_COMMAS);
	private static final String LINE_WITH_QUOTATIONS="\"Clarencé,Andersson\",2000,6,4";
	private static final String LINE_WITHOUT_QUOTATIONS="Clarencé Andersson,2000,6,4";

	@Test
	public void checkIfLineHasNumberOfCommasTest() {
		Optional<String> result = csvUtil.checkIfLineHasNumberOfCommas(LINE_WITH_CORRECT_COMMAS);
		assertTrue(result.isPresent());
		result = csvUtil.checkIfLineHasNumberOfCommas(LINE_WITH_INCORRECT_COMMAS);
		assertFalse(result.isPresent());
	}

	@Test
	public void filterForCsvLinesTest() {
		List<String> result = csvUtil.filterForCsvLines(LIST_OF_2);
		assertEquals(2, result.size());
	}
	
	@Test
	public void cleanCsvLineOfQuotesTest() {
		String result=csvUtil.cleanCsvLineOfQuotes(LINE_WITH_QUOTATIONS);
		assertTrue(result.equals(LINE_WITHOUT_QUOTATIONS));
	}
}
