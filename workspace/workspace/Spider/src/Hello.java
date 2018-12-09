@FunctionalInterface // can have only one abstract method
public interface Hello {
	String sayHello(String name);
	String toString();
	
	default void sayGoodbye() {
		System.out.println("Good Bye");
	}
	
	static void sayGreeting() {
		System.out.println("Have a Good Day");
	}
}
