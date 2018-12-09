import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestingAccounts {
	AccountTest ac ;
	double withdraw;
	@BeforeClass
	public static void oneTimeSetUp() {
		// One - time initialization code
		System.out.println("@BeforeClass - oneTimeSetUp");
		
	}
	
	@Before
	public void setUp()  {
		
		System.out.println("@Before - setUp");
		ac = new AccountTest(2000);
		//withdraw = ac.withdraw(1000);
	}

	@Test
	public void test_deposit() {
		System.out.println("Test if the  balance is updated");
		double amount = 100;
		double ini_bal = ac.getBalance();
		assertTrue(ac.deposit(amount) == ini_bal + amount );
	}
	
	@Test
	public void test_withdraw() throws BalanceException {
		System.out.println("Test if the withdrwal amount is updated");
		double amount = 100;
		double ini_bal = ac.getBalance();
		assertTrue(ini_bal - amount >= 1000 && amount <= ini_bal && ac.withdraw(amount) == ini_bal - amount);
	}
	
	@Test 
	public void test_minBalance() {
		System.out.println("Test if the balance is greater than 1000");
		AccountTest ac =  new AccountTest(1000);
		assertTrue(ac.getBalance() >= 1000);
	}
			
}
