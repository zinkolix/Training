package ex9;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfiguration {

	@Test
	public void serviceTest() {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(ServiceConfiguration.class);
		ExchangeService ex = (ExchangeService) appCtx.getBean("currency");
		ex.convert();
	}
}
