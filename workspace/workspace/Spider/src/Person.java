
public class Person implements People {
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		
		return "Person [" + name + ":" + age + "]";
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public void print() {
		
		People.super.print();    //a class can implement more than one interface. 
	}							// to prevent ambiguity.	
	
}
