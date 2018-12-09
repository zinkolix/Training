import java.util.StringJoiner;

public class StringJoinDemo {
	
	public static void main(String[] args) {
		
		StringJoiner sj = new StringJoiner(":","{", "");
		String name = "Polo";
		CharSequence age = "21";
		String city = "mumbai";
		sj.add("name");
		sj.add(name);
		String res = sj.toString();
		StringJoiner sk = new StringJoiner(":");
		sk.add("Age");
		sk.add(age);
		String res1 = sk.toString();
		StringJoiner sm = new StringJoiner(":");
		sm.add("city");
		sm.add(city);
		String res2 = sm.toString();
		StringJoiner sl = new StringJoiner(",","","}");
		sl.add(res);
		sl.add(res1);
		sl.add(res2);
		String res3 = sl.toString();
		
		System.out.println(res3);
	}

}
