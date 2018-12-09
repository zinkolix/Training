import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mphasis.pojo.Account;
import com.mphasis.util.HibernateUtil;

public class TestAccount {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Transaction txn = session.beginTransaction();
		 Account a = new Account();
		 a.setBalance(20000);
		 a.setHolder("Anshu");
		 
		session.save(a);
		txn.commit();

		factory.close();
	}

}
