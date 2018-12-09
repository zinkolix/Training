

//import com.mphasis.bank.AccountFactory;
//import com.mphasis.bank.BalanceException;
//import com.mphasis.bank.Bank;
//import com.mphasis.bank.Savings;

public class TestAccount {
	public static void main(String[] args) {
	
		
		Savings s1 = new Savings("Jack");
//		Bank s1 = AccountFactory.createAccount("Jack", "Savings");
//		//try {
//			s1.deposit(2000);
//		} catch (BalanceException e) {
//			
////			e.printStackTrace(); //for developers to troubleshoot
////			System.out.println(e); // for logging to audit
//			System.out.println(e.getMessage()); // For end users
//		}
		s1.deposit(3000);
		s1.statement();
//		s1.deposit(5000);
//		s1.withdraw(4000);
//		s1.summary();
//		s1.statement();
//		a1.deposit(1000);
//		System.out.println("Deposit");
//		a1.summary();
//		a1.withdraw(900);
//		System.out.println("Withdraw");		
//		a1.summary();
//		Current d1 = new Current("Shelly");
//		d1.withdraw(6000);
//		d1.summary();
//		d1.deposit(4000);
//		d1.summary();
//		d1.withdraw(20000);
//		d1.summary();
		
	}
}
