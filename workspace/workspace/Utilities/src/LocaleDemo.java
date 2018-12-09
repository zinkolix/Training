import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleDemo {

	public static void main(String[] args) {
		Locale hindi = new Locale("hi", "india");
		ResourceBundle bundle = ResourceBundle.getBundle("msgs", hindi); //Resource bundle only understand properties files
		
		System.out.println(bundle.getString("greeting"));
		System.out.println(bundle.getString("message"));

	}

}
