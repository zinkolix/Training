@Frustrated(level=5)
public class Student {
	private String name;
	
	 
	public Student(String name) {
		this.name = name;
	}
	
	@Tired(state = "Mentally")
	public void print() {
		System.out.println("Name: " + name);
		
	}

	@Override
	public String toString() {		
		return "Name: " + name;
	}
	

}
