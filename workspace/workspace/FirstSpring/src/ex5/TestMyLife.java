package ex5;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyLife {

	@Test
	public void lifeCycle() {
		ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("ex5/appctx.xml");
		appCtx.close();
	}
}
