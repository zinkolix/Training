
public class GroupingThread {
	public static void main(String[] args) {
	Thread t1 = new Thread("MyThread");
	t1.setPriority(1);
	t1.start();
	ThreadGroup defaultGroup = t1.getThreadGroup();
	defaultGroup.list();						//list the group of threads i.e main and myThread
	
	ThreadGroup parentGroup = defaultGroup.getParent();
	parentGroup.list();
	
	ThreadGroup myGroup = new ThreadGroup("MyGroup");
	Thread gt = new Thread(myGroup,"Another");
	gt.start();
	
	myGroup.list();
	defaultGroup.list();
	}
	
}
