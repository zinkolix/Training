package com.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.HelloWorld;

public class TestHelloWorld {

	@Test
	public void testSayHello() {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("mycontext.xml");
		HelloWorld hw = (HelloWorld)appCtx.getBean("hello");
		hw.sayHello();
	}
}
