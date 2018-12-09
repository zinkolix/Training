import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Assign1 {
	public static void main(String[] args) {
		String path = "C://Program Files";
		File file = new File(path);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		if(file.exists()) {
			if(file.isFile()) {
				System.out.println("File: " + file.getName());
			}
			else {
				File[] content  = file.listFiles();
				for (File f : content) {
					if(f.isFile())
						System.out.println("File: " + f.getName());
				
				else {
					Runnable worker = new ThreadAssign(f.getPath());
					executor.execute(worker);
				}
				}
				executor.shutdown();
				
				while(!executor.isTerminated()) {
					
				}
				
				System.out.println("Finished all thread..");
			}
		}else {
			System.out.println("File does not exist....");
		}
	}
	
}
