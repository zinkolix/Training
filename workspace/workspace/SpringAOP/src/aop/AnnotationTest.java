package aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AnnotationTest {

	@Test
	public void test() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Account a1 = context.getBean(Account.class);
		a1.deposit(1000);
//		 a1.summary();
//		 a1.getBalance();
//		 try {
//		 a1.withdraw(900);
//		 } catch (BalanceException e) {
//		 }
		 a1.fundTransfer(1, 2);
	}
}
