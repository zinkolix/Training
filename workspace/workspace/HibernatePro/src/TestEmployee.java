
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.mphasis.entity.Department;
import com.mphasis.entity.Employee;
import com.mphasis.util.HibernateUtil;

public class TestEmployee {

	@Test
	public void testAddingRecords() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction txn = session.getTransaction();

		Department dept = new Department();
		dept.setDeptNo(20);
		dept.setDeptName("Accounts");

		Employee e1 = new Employee();
		e1.setEmpName("Mili");
		e1.setSalary(3000);
		e1.setDept(dept);

		Employee e2 = new Employee();
		e2.setEmpName("Jack");
		e2.setSalary(4000);
		e2.setDept(dept);

		Set<Employee> emps = new HashSet();
		emps.add(e1);
		emps.add(e2);
		dept.setEmployees(emps);

		txn.begin();
		session.save(dept);
		txn.commit();

		factory.close();

	}

	@Test
	public void fetchDepartment() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction txn = session.getTransaction();

		// Transaction is required when the tables are joined
		txn.begin();
		Department d = (Department) session.get(Department.class, 10);
		System.out.println("Dept Name: " + d.getDeptName());
		for (Employee e : d.getEmployees())
			System.out.println("Name: " + e.getEmpName() + "\tSalary: " + e.getSalary());

		txn.commit();
		factory.close();
	}

	@Test
	public void testAddNewEmployee() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction txn = session.getTransaction();

		txn.begin();
		Department d = (Department) session.get(Department.class, 10);
		Employee e = new Employee();
		e.setEmpName("Maria");
		e.setSalary(3500);
		e.setDept(d);

		session.save(e);
		txn.commit();

		factory.close();
	}

	@Test
	public void testFetchEmployee() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction txn = session.getTransaction();

		txn.begin();
		Employee e = (Employee) session.get(Employee.class, 65536);
		System.out.println("Name: " + e.getEmpName() + "\t Salary: " + e.getSalary() + " Department Name: "
				+ e.getDept().getDeptName());
		txn.commit();
	}

}
