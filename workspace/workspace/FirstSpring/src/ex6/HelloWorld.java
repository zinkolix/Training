package ex6;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hello")
public class HelloWorld {

	private String greeting;

	public HelloWorld() {

	}

	public HelloWorld(String greeting) {
		this.greeting = greeting;
	}

	@Value("Welcome to Spring")
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public void sayHello() {
		System.out.println(greeting);
	}

}
