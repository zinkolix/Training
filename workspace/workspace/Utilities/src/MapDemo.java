import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringJoiner;

public class MapDemo {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap();
		String K;
		String V;
		map.put("scott", "tiger");
		map.put("jack", "jill");
		map.put("polo", "lili");
		map.put("jack", "rose"); // duplicate keys are not allowed. if entered the values are overwritten.
		
		System.out.println(map);
		StringJoiner joiner = new StringJoiner(" , ","{","}");
		for (String key : map.keySet()) {
			joiner.add(key + " : " + map.get(key));
			System.out.println(key + ": " + map.get(key));
		}
		System.out.println(joiner);
		
		
		
		
//		System.out.println(map.get("polo"));
//		System.out.println(map.get("jack"));
	}

}
