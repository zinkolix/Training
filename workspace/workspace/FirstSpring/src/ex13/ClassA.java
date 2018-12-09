package ex13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ClassA {

	@Autowired
//	@Lazy
	private ClassB classB;

	public ClassA() {
		System.out.println("Constructor of classA()");
	}

	public void someMethod() {
		classB.someOtherMethod();
	}
}
