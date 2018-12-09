import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.mphasis.entity.*;
import com.mphasis.util.HibernateUtil;

public class TestCustomer {
	@Test
	public void testNewCustomer() {
		Customer c1 = new Customer();
		c1.setCustId(1);
		c1.setCustName("Neera");
		c1.setCredit(5000);

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession(); // session can be openSession
													// or getCurrentSession -
													// multiple session in the
													// connection pool
		Transaction txn = session.getTransaction();

		try {
			txn.begin();
			session.save(c1); // an object is passed which will parse the object
								// and does the required operation in the
								// Database
			txn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback(); // If transaction failed rollback any updation
		} finally {
			session.close();
			factory.close();
		}

	}

	@Test
	public void testFetchCustomer() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Customer c = (Customer) session.get(Customer.class, 1);
		System.out.println("Name: " + c.getCustName());
		System.out.println("Credit: " + c.getCredit());

		factory.close();

	}

	@Test
	public void testUpdateCustomer() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();
			Customer c = (Customer) session.get(Customer.class, 1);
			c.setCredit(1000);
			session.update(c);
			txn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
		} finally {
			factory.close();
		}
	}

	@Test
	public void testRemoveCustomer() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();
			Customer c = (Customer) session.get(Customer.class, 32768);
			session.delete(c);
			txn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
		} finally {
			factory.close();
		}
	}

}
