package com.spring.ex2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMessageService {

	@Test
	public void messageSender(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/spring/ex2/appctx.xml");
		MessageProvider provider = (MessageProvider)ctx.getBean("provider");
		provider.serviceProvider("email", "iam@gmail.com", "how are you");
		provider.serviceProvider("sms", "9876543210", "How do u do");
		provider.serviceProvider("tweet", "@zinkixx", "I'm the king");
	}
}
