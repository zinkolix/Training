
public class GenericDemo<Z> {
	private Z data;

	public GenericDemo(Z data) {
		this.data = data;
	}

	public void setData(Z data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data.toString();
	}
	
	public static void main(String[] args) {
		GenericDemo<String> d1 = new GenericDemo<String>("Hello"); // The objects are specific to the string type.
		System.out.println(d1);
		
		GenericDemo<Integer> d2 = new GenericDemo<Integer>(1000); // The objects are specific to the Integer type.
		System.out.println(d2);
		
		GenericDemo g = new GenericDemo(1000); // If generic type is not specified then the object is generic and can hold any type of data
		g.setData("Hello");
		System.out.println(g);
	}
	
}
