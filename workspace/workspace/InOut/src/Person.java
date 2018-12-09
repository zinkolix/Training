import java.io.Serializable;

public class Person implements Serializable { // Serializable and clonable are marker interfaces-
	private String name;
	private int age;
	
	public Person() {
		
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\tAge: " + age;
	}
	
	
}
