import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.mphasis.product.Person;

public class PersonReflection {
	public static void main(String[] args) throws Exception {
		Person p = new Person("Polo", 21);
		System.out.println(p);
		
		//Class pc = p.getClass();     	  // There is a class named class in java where we can getClass
		//Load a class manually.
		Class pc = Class.forName("Person");
		System.out.println(pc.getName()); // Prints the name of the class
		
		//To get constructor of the class
		Constructor[] constructors = pc.getConstructors();
		for (int i = 0; i < constructors.length; i++) {
			System.out.println(constructors[i]);
		}
		
		//To get methods 
		Method[] methods = pc.getMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println(i + " " +methods[i]);
		}
		Method[] decMethods = pc.getDeclaredMethods();
		for (int i = 0; i < decMethods.length; i++) {
			System.out.println(i + "  " + decMethods[i]);
		}
		
		Field[] fields = pc.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println( i + " " +fields[i]);
			
		}
	}

}
