import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.account.service.AccountService;
import com.account.service.AccountServiceImpl;

public class TestAccountService {
	private AccountService service;
	@Before
	public void setUp(){
		service = new AccountServiceImpl();
	}
	@After
	public void tearDown(){
		service = null;
	}
	
	@Test
	public void testAddingAccount(){
		int acntId = (int) service.addAccount("Ashwin");
				System.out.println("Account Id: " + acntId);
	}
}
