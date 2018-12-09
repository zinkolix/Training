
public class AssertDemo3 {
	public static void main(String[] args) {
		int empNo = (int) (Math.random() * 99999);
		
		assert empNo >= 10000 && empNo <= 99999 : "Invalid employee no: " + empNo ;
		
		System.out.println("EmpNo: " + empNo);
	}
}
