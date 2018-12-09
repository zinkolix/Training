
public class TestPerson {
	public static void main(String[] args) {
		Person p = new Person("Polo", 21);
		System.out.println(p);
		p.print();
		p.sayHello();
		System.out.println(p.pi());
		System.out.println(p.max(1, 2));
		//People pp = p;
		System.out.println(People.kid(p));
		System.out.println(People.teenager(p));
		
		Person p2 = new Person("Lili", 19);
		System.out.println(People.teenager(p2));
		System.out.println(People.kid(p2));
		
		System.out.println(People.ageDiff(p,p2));
		
	
	}
}
