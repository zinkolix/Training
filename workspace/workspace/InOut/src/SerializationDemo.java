import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {
	public static void main(String[] args) {
		Person p = new Person("Polo", 21);
		ObjectOutputStream ostream = null;
		ObjectInputStream istream = null;
		String path = "C:\\Users\\Ashwini.Sharma08\\Desktop\\temp.dat";
		
		//Writing object to file: serialization
		try {
			ostream = new ObjectOutputStream(new FileOutputStream(path));
			ostream.writeObject(p);
			System.out.println("Person Serialized...");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		try {
		//Reading the object from a file: Deserialization
			istream = new ObjectInputStream(new FileInputStream(path));
			Object obj = istream.readObject();
			System.out.println(obj);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		finally {
			try {
				if(istream!=null)
					istream.close();
			} catch (IOException e) {
		
				e.printStackTrace();
			}
		}
	}
	
	
}
