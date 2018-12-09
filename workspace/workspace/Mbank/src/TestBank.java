import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.mphasis.bank.entity.Account;
import com.mphasis.bank.entity.Customer;
import com.mphasis.bank.entity.DepositAccount;
import com.mphasis.bank.util.HibernateUtil;


public class TestBank {

	@Test
	public void testAddingRecords(){
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction txn = session.beginTransaction();
		
		Customer cust = new Customer();
		cust.setCustId("MLA12346");
//		cust.setBirthDate();
		cust.setCustName("Anshu");
		cust.setPan("12345678");
		cust.setPassword("guitar");
		session.save(cust);
		Account a1 = new Account();
		a1.setAcntId("SB12346");
		a1.setAcntType("SB");
//		a1.setCustId(cust.getCustId());
		a1.setCust(cust);
		
		session.save(a1);
		
		txn.commit();
//		session.close();
		factory.close();
		
	}
	@Test
	public void testAddDepositAccount(){
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction txn = session.beginTransaction();
		
		Account a = (Account) session.get(Account.class, "SB12346");
		DepositAccount da = new DepositAccount();
		da.setDepositId(1);
		da.setBalance(10000);
		da.setAcnt(a);
		session.save(da);
		txn.commit();
		factory.close();
	}

}
