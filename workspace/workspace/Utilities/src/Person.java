
public class Person implements Comparable<Person>{
	private String name;
	private int age;
	boolean flag;
	public Person() {
	
	}
	
	public Person(String name, int age) {
		
		this.name = name;
		this.age = age;
//		this.flag = flag;
	}
	
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		
		return "Name: " + name + "Age: " + age;
	}

	@Override
	public int compareTo(Person p) {
		//if(flag == true)
			return this.age - p.age;
		
	}
	
	
	
	
}
