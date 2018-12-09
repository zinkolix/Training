package com.mphasis.product;

public class Person implements Cloneable{
	private String name;
	private int age;


	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person() {
		// Calling another constructor on the same object with matching signature.
		this("Anonymous", -1);
		
	}

	public void setState(String pname, int page) {
		name = pname;
		age = page;

	}
	
	public void print() {
		System.out.println("Name: " + name + "\t Age: " + age);
		
	}
	
	public static void main(String[] args) throws Exception{
		Person p = new Person("Polo", 21);
		Person p2 = (Person)p.clone();
		System.out.println(p2);
//		Person p = null;
//		for(int c = 1; c <= 5; c++)
//			p = new Person();
//		
//		System.gc();
//		Person p = new Person("Polo", 21);
//		Person p2 = new Person("Polo", 21);
//		System.out.println(p.equals(p2));
//		System.out.println(p.hashCode());
//		System.out.println(p2.hashCode());
//		System.out.println(p); 						// implicitly calls to string
//		p.print();
//		Person p2 = new Person();
//		p2.print();
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Person is no more");
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person){
			Person p = (Person) obj;
			if(name.equals(p.name) && this.age == p.age)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name: " + name + "\t Age: " + age;
	}
}
