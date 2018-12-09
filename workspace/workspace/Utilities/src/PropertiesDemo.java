import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

public class PropertiesDemo {
	public static void main(String[] args) {
		Properties p = new Properties();
		try {
			p.load(new FileReader("src/person.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println(p.getProperty("name"));
		System.out.println(p.getProperty("age"));
		System.out.println(p.getProperty("city"));
		
	}
}
