
public class ArrayDemo {

	public static void main(String[] args) {
		int[] ar = {40, 20, 50, 10, 30};
		
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
		for (int i = 0; i < ar.length - 1; i++) {
			for (int j = 0; j < ar.length - 1; j++) {
				if(ar[j] > ar[j+1]) {
					int temp = ar[j+1];
						ar[j+1] = ar[j];
						ar[j] = temp;
				}	
			}			
		}
		System.out.println("SORT");
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
//		int[][] jaggu = {{1,2}, {3,4,5}, {6,7,8,9}};
		
//		for (int i = 0; i < jaggu.length; i++) {
//			for (int j = 0; j < jaggu[i].length; j++) {
//				System.out.print(jaggu[i][j] + " ");	
//				
//			}
//			System.out.println();
//		
//			
//		}

	}

}
