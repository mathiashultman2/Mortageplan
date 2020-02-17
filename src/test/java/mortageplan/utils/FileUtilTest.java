package mortageplan.utils;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

public class FileUtilTest {
	private final FileUtil fileUtil = new FileUtil();

	@Test
	public void readFileTest() {
		List<String> lines = fileUtil.readFile();
		assertEquals(8,lines.size());
	}
}
