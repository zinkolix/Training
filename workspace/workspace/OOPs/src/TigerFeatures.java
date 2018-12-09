import static java.lang.Math.*;
import static java.lang.System.out;
public class TigerFeatures {
	public static void main(String[] args) {
		out.println(Math.random());
		out.println(Math.max(10,20));
		out.println(ceil(1.345));
		out.println(PI);
		
		int[] ar = {10, 20, 30, 40, 50};
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
		//Foreach: No control on the conditions of the loop
		for (int i : ar) 
			System.out.println(i);
			

	}
}
