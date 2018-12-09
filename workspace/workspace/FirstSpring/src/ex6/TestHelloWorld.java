package ex6;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHelloWorld {

	@Test
	public void testGreeting(){
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("annotatedappctx.xml");
		HelloWorld hw = (HelloWorld)appCtx.getBean("hello");
		hw.sayHello();
	}
}
