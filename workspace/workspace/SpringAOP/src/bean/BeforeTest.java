package bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeforeTest {

	@Test
	public void testingBefore() {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("bean/appctx.xml");
		Account a1 = (Account) appCtx.getBean("acnt");
//		a1.deposit(1000);
//		 a1.summary();
//		 a1.getBalance();
//		 try {
//		 a1.withdraw(900);
//		 } catch (BalanceException e) {
//		 }
		 a1.fundTransfer(1, 2);
	}
}
