package mortageplan.utils;

import static org.junit.Assert.*;
import org.junit.Test;

public class MathUtilTest {
	private MathUtil mathUtil = new MathUtil();

	@Test
	public void powTest() {
		double result = mathUtil.pow(3, 3);
		assertTrue(27==result);
		result = mathUtil.pow(3, 4);
		assertTrue(81==result);
	}

}
