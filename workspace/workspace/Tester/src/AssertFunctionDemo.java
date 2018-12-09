import static org.junit.Assert.*;

import org.junit.Test;

public class AssertFunctionDemo {
 
	@Test
	public void testAssert() {
		// Variable Declaration
		
		String string1 = "Junit";
		String string2 = "Junit";
		String string3 = "test";
		String string4 = "test1";
		String string5 = null;
		int variable1 = 1;
		int variable2 = 2;
		int[] arithmeticArray1 = { 1, 2, 3 };
		int[] arithmeticArray2 = { 1, 2, 3 };
		
		//Assert statement arithmetic
		assertEquals(string1, string2);
		assertSame(string3, string4);
		assertNotSame(string1, string3);
		assertNotNull(string1);
		assertNull(string5);
		assertTrue(variable1 < variable2);
		assertArrayEquals(arithmeticArray1, arithmeticArray2);
	}
}
