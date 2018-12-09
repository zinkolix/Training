import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Assign {

	public static void main(String[] args) {
		boolean flag = false;
		Properties p = new Properties();
		try {
			p.load(new FileReader("src/cities.info"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("Enter key");
		Scanner console = new Scanner(System.in);
		String ukey = console.nextLine().trim();
		HashMap<String, String> hmap = new HashMap(p);
		Set<String> kset = hmap.keySet();
		for(String key : kset){
			if(ukey.equalsIgnoreCase(key)){
				StateCities stcty = new StateCities();
				ArrayList<String> cities = new ArrayList();
				stcty.setKey(key);
				String str = hmap.get(key);
				stcty.setState(str.substring(0, str.indexOf("[")));
				String strCities = str.substring(str.indexOf("[")+1, str.length() - 1);
				StringTokenizer citiesTokens = new StringTokenizer(strCities,";");
				while(citiesTokens.hasMoreTokens()){
					cities.add(citiesTokens.nextToken());
					
				}
			stcty.setCities(cities);
			if(stcty != null){
				stcty.print();
				flag = true;
			}
		}
			
	}
	if(flag != true)
		System.out.println("Key not found..");
	}
}
