
public class PrimeDemo {
	public static void main(String[] args) {
		boolean flag = false;
		for(int i = 1; i <= 100; i++) {
			flag = false;
			
			for(int j = 2; j < i; j++ ){
				if(i % j == 0)
					flag = true;
			}
			
			if(flag == true)
				System.out.println("Not Prime: " + i);
			else
				System.out.println("Prime: " + i);			
		}
			
	}
}
