import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mphasis.pojo.Employee;
import com.mphasis.service.EmployeeService;
import com.mphasis.service.EmployeeServiceImpl;
import com.mphasis.util.InvalidEmployeeException;

public class TestEmployee {
	public static void main(String[] args) throws InvalidEmployeeException {
		Scanner scan = new Scanner(System.in);
		int empNo;
		Employee e = new Employee(5,"Scott",50000,400);
		EmployeeService es = new EmployeeServiceImpl();
		List<Employee> employees = new ArrayList<Employee>();
		
		System.out.println("-------Menu---------");
		System.out.println("1. Add new employees");
		System.out.println("2. Show all employees");
		System.out.println("3. Update salary ");
		System.out.println("4. Delete Employee");
		System.out.println("Enter your choice: ");
		int choice = scan.nextInt();
		switch (choice) {
		case 1: if(es.addEmployee(e) == true)
					System.out.println("Record inserted");
				else
					throw new InvalidEmployeeException("Record is not inserted");
				break;
		case 2: employees = es.showAllEmployee();
//			for (Employee e1 : employees) {
//					System.out.println(e1);
//					}
				break;
		case 3: 
				if(es.updateSalary(2) == true)
					System.out.println("Record Updated");
				else
					System.out.println("Employee id is not in the table");
				break;
		case 4: if(es.deleteEmployee(2) == true)
					System.out.println("Record Deleted");
		else
					throw new InvalidEmployeeException("Employee id is not in the table");
		
				break;
		default:
				System.out.println("Invalid choice");
			break;
		}
		
		
	}

}
