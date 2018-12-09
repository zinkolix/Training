package com.spring.ex4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyServiceLocatorTest {

	@Test
	public void testLocatingService(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/ex4/appctx.xml");
		MyService myService1 = (MyService)context.getBean("myService");
		MyService myService2 = (MyService)context.getBean("myService",100);
		myService1.doService();
		
		System.out.println(myService1 == myService2);
	}
}
