import static org.junit.Assert.*;

import org.junit.Test;

public class TestEmployee {

	@Test
	public void testEmpNo() {
		int empNo = (int) (Math.random() * 99999);
		
		assertTrue(empNo >= 10000 && empNo <= 99999);
		System.out.println("EmpNo: "+ empNo);
	}
	
}
