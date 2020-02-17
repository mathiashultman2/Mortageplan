package mortageplan;

import java.util.List;

import mortageplan.utils.CsvUtil;
import mortageplan.utils.FileUtil;
import mortageplan.utils.MathUtil;

public class Main {
	private FileUtil fileUtil=new FileUtil();
	private CsvUtil csvUtil=new CsvUtil(new MathUtil());
	private int counter=1;
	
	public static void main(String[] args) {
		new Main().go();
	}
	
	public void go() {
		List<String> lines = fileUtil.readFile();
		lines = csvUtil.filterForCsvLines(lines);
		lines.stream().skip(1).forEach(line->{
			line=csvUtil.cleanCsvLineOfQuotes(line);
			csvUtil.processLine(line, counter++);
		});
	}
}
