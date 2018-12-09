import com.mphasis.product.Person;

public class Demo {
	private Object data;
	
	static { // Static initializer block - executes on class loading.	
		System.out.println("Class loaded...");
	}
	{	//instance initializer block - executes for each instantiation
		System.out.println("Object created... ");
	}

	public Demo(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data.toString();
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public static void main(String[] args) {
		Demo d = new Demo("hello");
		Demo d2 = new Demo(1000);
		Demo d3 = new Demo(new Person("Polo", 23));
		
		System.out.println(d);
		System.out.println(d2);
		System.out.println(d3);
		
		d2.setData("Jack");
		System.out.println(d2);
	}
}
