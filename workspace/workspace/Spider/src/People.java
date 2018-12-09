
public interface People {
	int getAge();
	String getName();
	
	static boolean teenager(People p) {
		return p.getAge() <= 19 && p.getAge() >= 13;
	}
	
	static boolean kid(People p){
		return p.getAge() >= 0 && p.getAge() < 13;
	}
	
	default void print() {		//default method can be implemented in the interfaces
		System.out.println("Name: " + getName() + "Age: " + getAge());
	}
	
	default void sayHello() {
		System.out.println("Hello world");
	}
	
	default double pi() {
		return 3.14;		
	}
	
	default int max(int a, int b) {
		return a>b?a:b;
	}
	static int ageDiff(Person p, Person p2) {
		
		return p.getAge() - p2.getAge();
	}
}
