package ex8;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyLife {

	@Test
	public void lifeCycle() {
		ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("annotatedappctx.xml");
		appCtx.close();
	}
}
