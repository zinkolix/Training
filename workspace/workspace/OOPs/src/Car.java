
public class Car {
	private String model;
	private String[] features;
	
	public Car(String model, String... features) { // Var-args can only be used on the last params
		this.model = model;
		this.features = features;
	}
	
	public void specs() {
		System.out.println("Features of " + model);
		for (String feature : features) {
			System.out.println(feature);
		}
		
	}
	public static void main(String[] args) {
		//String[] af = { "Power Steering", "Power Window", "Keyless Entry"};
		Car alto = new Car("Alto", "Power Steering", "Power Window", "Keyless Entry");
		
		//String[] sf = { "Keyless", "ABS", "Projector Lamp", "Power Steering", "Power Window"};
		Car swift = new Car("Swift", "Keyless", "ABS", "Projector Lamp", "Power Steering", "Power Window");
		
		alto.specs();
		swift.specs();
	}
}

