import java.util.ArrayList;

public class StateCities {
	
	private String key;
	private String state;
	private ArrayList<String> cities;
	
	public StateCities() {
	
	}
	public void setCities(ArrayList<String> cities) {
		this.cities = cities;
	}
	public StateCities(String key, String state, ArrayList<String> cities) {
		this.key = key;
		this.state = state;
		this.cities = cities;
	}
	
	public void print() {
		System.out.println("Key: " + key);
		System.out.println("State: " + state);
		System.out.println("Popular cities are: ");
		for (int i = 0; i < cities.size(); i++) {
			System.out.println(cities.get(i));
		}
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public ArrayList<String> getCities() {
		return cities;
	}
	
	

}
