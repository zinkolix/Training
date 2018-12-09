
public class Employee {
	private int empNo;
	private String empName;
	private double salary;
	
	public Employee() {
	
	}

	public Employee(int empNo, String empName, double salary) {
		
		this.empNo = empNo;
		this.empName = empName;
		this.salary = salary;
	}

	@Override
	public String toString() {
		
		return "Employee [" + empNo + ":" + empName + ":" + salary + "]";
	}

	public int getEmpNo() {
		return empNo;
	}


	public String getEmpName() {
		return empName;
	}


	public double getSalary() {
		return salary;
	}


	
	
	
	
	
}
