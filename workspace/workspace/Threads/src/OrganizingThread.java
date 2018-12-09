

public class OrganizingThread implements Runnable {

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		display(name);

	}

	private Object obj =  new Object();
	
	//private synchronized void display(String name) { 	//Synchronized keyword sync the thread and allow to finish the entered thread to complete its task.
	private void display(String name) {
		System.out.println("Thread entered...");
		
		
	//	synchronized (this) {     //synchronized keyword can be used to create a block in sync
		synchronized (obj) {	//Blocking a dummy object to sync.	
			
			
		try {
			System.out.print("[");
			Thread.sleep(1000);
			System.out.print(name);
			Thread.sleep(1000);
			System.out.print("]");
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		OrganizingThread ot = new OrganizingThread();
		Thread t1 = new Thread(ot,"First");
		Thread t2 = new Thread(ot, "Second");
		Thread t3 = new Thread(ot, "Third");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
