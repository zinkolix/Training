package ex13;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ClassB {

	public ClassB() {
		System.out.println("constructor of classB()");
	}

	public void someOtherMethod() {

	}
}
