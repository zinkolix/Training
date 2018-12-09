
public class FactorialDemo {

	public static void main(String[] args) {
		
		for(int i = 2; i <= 100; i++) {
			int j = 1;
			double fact = 1;
			while(i != j) {
				fact = fact * j;
				j++;
			}
			System.out.println(fact);
		}
				
	}

}
