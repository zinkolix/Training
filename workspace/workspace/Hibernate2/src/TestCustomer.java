import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mphasis.pojo.Customer;

public class TestCustomer {

	public static void main(String[] args) {
		Customer c1 = new Customer();
		c1.setCustId(1);
		c1.setCustName("Polo");
		c1.setCredit(5000);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction txn = session.getTransaction();
		
		txn.begin();
		session.save(c1);
		txn.commit();

	}
}
