import com.mphasis.org.Employee;
import com.mphasis.org.Executive;
import com.mphasis.org.Manager;

public class TestEmployee {

	public static void main(String[] args) {
		//Employee e1 = new Employee("Polo", 5000);
		//e1.payslip();
		//Employee e2 = new Employee("anshu", 23000);
		//e2.payslip();
		//System.out.println("----------");
		
		Executive ex = new Executive("mili", 6000, 2000);
		
		//System.out.println("----------");
		Manager mg = new Manager("Shama", 12000,2000);
		
		
		showSalary(ex);
		showSalary(mg);
		
	}
	//Polymorphism
	private static void showSalary(Employee e) {
		//Runtime Type Identification
		if(e instanceof Manager)			
			System.out.println("Manager Salary: " + e.getSalary());
		else
			System.out.println("Executive Salary: " + e.getSalary());
		
	}
	
	

//	private static void showSalary(Executive ex) {
//		
//		System.out.println("Executive Salary: " + e.getSalary());
//		
//	}
//
//	private static void showSalary(Manager mg) { 
//		System.out.println("Manager Salary: " + e.getSalary());
//		
//	}

}
