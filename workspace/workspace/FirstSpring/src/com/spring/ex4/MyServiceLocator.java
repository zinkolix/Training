package com.spring.ex4;

public class MyServiceLocator {

	public MyService createMyService() {
		// We assume there is complex code to initialize MyService bean
		System.out.println("Just Checking");
		return new MyService();
	}

	public MyService createMyService(int id) {
		// some database specific code to fetch values required for intantiating
		// the bean
		System.out.println("Just Checking" + id);
		return new MyService();
	}

	public MyService createMyService(String someParameter) {
		// some database specific code to fetch values required for
		// instantiating the bean
		System.out.println("Just Checking" + someParameter);
		return new MyService();
	}
}
