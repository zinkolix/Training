package ex11;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// i18n implementation using spring
public class MessageSourceTest {

	@Test
	public void testI18n() {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("ex11/appctx.xml");
		OrderProcessingService orderProcessingService = appCtx.getBean(OrderProcessingService.class);
		try {
			orderProcessingService.placeOrder(5);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
