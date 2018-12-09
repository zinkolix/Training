package application;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDao {
	
	private Session getSession() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}
	
	public List<User> getAllUsers() {
		Session session = getSession();
		Transaction txn = session.beginTransaction();
		List<User> userList = session.createQuery("from User").list();
		txn.commit();
		return userList;
	}

	public boolean addUser(User user) {
		Session session = getSession();
		Transaction txn = session.beginTransaction();
		try {
			session.save(user);
			txn.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			txn.rollback();
			return false;
		}
	}

	public User getUser(int userid) {
		Session session = getSession();
		Transaction txn = session.beginTransaction();
		User user = (User) session.get(User.class, userid);
		return user;
	}

	public boolean updateUser(User user) {
		Session session = getSession();
		Transaction txn = session.beginTransaction();
		try {
			session.update(user);
			txn.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			txn.rollback();
			return false;
		}
	}

	public boolean deleteUser(int userid) {
		Session session = getSession();
		Transaction txn = session.beginTransaction();		
		User user = (User) session.get(User.class, userid);
		try {
//			txn.begin();
			
			session.delete(user);
			txn.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
}



