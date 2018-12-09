import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mphasis.pojo.Person;
import com.mphasis.util.HibernateUtil;

public class TestPerson {

	public static void main(String[] args){
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Transaction txn = session.beginTransaction();
		Person p = new Person(new Person.Id("India",123), "Polo",21);
		session.save(p);
		txn.commit();
		factory.close();
	}
}
