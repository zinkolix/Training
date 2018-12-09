public class AssertDemo2 {

	public static void main(String[] args) {

		int argCount = args.length;
		
		assert argCount == 5 : "The number of arguments must be 5";
		
		for (String arg : args) {
			System.out.println(arg);
		}
	}

}
