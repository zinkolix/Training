
public class ArmstrongNumberDemo {

	public static void main(String[] args) {
								//int temp = 0, sum = 0, rem = 0;
		for(int i = 1; i <= 500; i++) {
			int temp = i; 
			int sum = 0;		// rem = 0;
			while(temp != 0) {
				int rem = temp % 10;
				sum += (rem * rem * rem);
				temp = temp / 10;
				
			}
			if( sum == i)
				System.out.println(" " + sum);
			
		}

	}

}
