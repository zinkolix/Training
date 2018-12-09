
public class StringDemo {

	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = new String("Hello");
		String s3 = "Hello";
		
		//Comparing string references
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		
		//Comparing string values
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		
		s1 = s1 + "World";
		System.out.println(s1);
		System.out.println(s1.length());
		System.out.println(s1.toUpperCase());
		System.out.println(s1.toLowerCase());
		
		System.out.println(s1.charAt(4));
		System.out.println(s1.indexOf('o'));
		System.out.println(s1.lastIndexOf('o'));
		
		System.out.println(s1.substring(3));
		System.out.println(s1.substring(3,6));
		System.out.println(s1.replace('o', 'a'));

		int idx = 0;
		while(true) {
			idx = s1.indexOf('o',idx+1);
			if(idx == -1) break;
			System.out.println(idx);
		}
	}

}
