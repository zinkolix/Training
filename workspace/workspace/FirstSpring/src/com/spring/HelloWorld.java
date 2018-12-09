package com.spring;

public class HelloWorld {

	private String greeting;

	public HelloWorld() {

	}

	public HelloWorld(String greeting) {
		this.greeting = greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public void sayHello() {
		System.out.println(greeting);
	}

}
