
public class CmdLineDemo {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < args.length; i++) {
			//Parsing int out of string and adding to sum
			sum += Integer.parseInt(args[i]);
		}
		
		System.out.println("Sum: " + sum);

		Integer io = 100;  		//boxing
		int var = io;  			//unboxing
		int foo = io * var;		//Auto-Boxing
		
		
		
	}

}
