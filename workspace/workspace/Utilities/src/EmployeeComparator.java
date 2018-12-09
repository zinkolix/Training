import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class EmployeeComparator {
	
	public static Comparator<Employee> sortByEmpNo() {
	Comparator<Employee> comp = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			
			return e1.getEmpNo() - e2.getEmpNo();
		}
		
	};
	return comp;
}
	
	public static Comparator<Employee> sortBySalary() {
		Comparator<Employee> comp = new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				
				return (int)e1.getSalary() - (int)e2.getSalary();
			}
			
		};
		return comp;
	}
	
	public static Comparator<Employee> sortByName() {
		return new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				
				return e1.getEmpName().compareTo(e2.getEmpName());
			}
			
		};
		
	}
	
	public static void main(String[] args) {
//	SortedSet<Employee> emps = new TreeSet(EmployeeComparator.sortByEmpNo());
	SortedSet<Employee> emps = new TreeSet(EmployeeComparator.sortByName());
//	SortedSet<Employee> emps = new TreeSet(EmployeeComparator.sortBySalary());
	emps.add(new Employee(101, "Polo", 5000));
	emps.add(new Employee(201,"Lili",4000));
	emps.add(new Employee(102, "Mili", 6000));
	
	for (Employee e : emps) {
		System.out.println(e);
		}
	}
}
