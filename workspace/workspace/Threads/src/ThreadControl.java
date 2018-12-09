
public class ThreadControl extends Thread {

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		for(int c = 1; c <= 50; c++){
			System.out.println(name + " : " + c);
			yield();									//It gives the other thread to print when other thread is busy with incrementing c value.
//			try {
//				Thread.sleep(1);						//Sleep the thread to give other thread the chance to execute
//														//Sleep introduces additional time with the execution time of the system.
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new ThreadControl();
		t1.setName("First");
		
		Thread t2 = new ThreadControl();
		t2.setName("Second");
		
		Thread t3 = new ThreadControl();
		t3.setName("Third");
		
		t1.start();
		t2.start();
		t3.start();
	}
	

}
