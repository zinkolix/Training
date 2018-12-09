import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mphasis.pojo.Book;
import com.mphasis.util.HibernateUtil;

public class TestBook {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Transaction txn = session.beginTransaction();
		 Book b = new Book();
		 b.setIsbn(1234);
		 b.setAuthor("Savi Sharma");
		 b.setTitle("Everyone has a story");
		session.save(b);
		txn.commit();
		factory.close();
	}

}
