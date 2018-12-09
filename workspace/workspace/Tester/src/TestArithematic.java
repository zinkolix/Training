import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestArithematic {
	private int expected;
	private int first;
	private int second;
	
	public TestArithematic(int expected, int first, int second) {
		this.expected =  expected;
		this.first = first;
		this.second = second;
	}
	
	@Parameters
	public static Collection<Integer[]> addedNumbers() {
		return Arrays.asList(new Integer[][] {{3, 1, 2 }, {5, 2, 3}, {7, 3, 4}, {9, 4, 5}, });
		
	}
	
	@Test
	public void sum() {
		Arithematic add = new Arithematic();
		System.out.println("Addition of : " + first + " and " + second + " = " + expected);
		assertEquals(expected,add.addition(first, second));
	}

}
