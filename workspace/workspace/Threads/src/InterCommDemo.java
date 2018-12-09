
class Base {
	private int data;
	private boolean flag;
	public synchronized void set() {
		try {
			if(flag == true)
				wait();
			data = (int)(Math.random() * 100);
			System.out.println("Set: " + data);
			flag = !flag;
			notify();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public synchronized void get() {
		try {
			if(flag == false)
				wait();
			System.out.println("Get: " + data);
			flag = !flag;
			notify();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
class Producer extends Thread {
	private Base obj;

	public Producer(Base obj) {		
		this.obj = obj;
	}

	@Override
	public void run() {
		for(int c = 1; c <= 100; c++)
		obj.set();
		}
	
}

class Consumer extends Thread {
	private Base obj;

	public Consumer(Base obj) {		
		this.obj = obj;
	}

	@Override
	public void run() {
		for(int c = 1; c <= 100; c++)
			obj.get();
	}
	
	
	
}
public class InterCommDemo {
	public static void main(String[] args) {
	Base base = new Base();
	Producer p = new Producer(base);
	Consumer c = new Consumer(base);
	p.start();
	c.start();
	}
}
