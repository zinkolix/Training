package com.spring.ex3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClientService {

	@Test
	public void testService(){
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("com/spring/ex3/appctx.xml");
		ClientService cs1= (ClientService)appCtx.getBean("service");
		ClientService cs2 = (ClientService)appCtx.getBean("service");
		
		System.out.println(cs1 == cs2);
	}
}
