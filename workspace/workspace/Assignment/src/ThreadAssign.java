import java.io.File;

public class ThreadAssign implements Runnable {
	private String path;
	
	
	public ThreadAssign(String path) {		
		this.path = path;
	}


	@Override
	public void run() {
	File file = new File(path);
	deep(file);

	}
	
	public void deep(File file) {
		if(file.exists()) {
			if(file.isFile()){
				System.out.println("File: " + file.getName());
			} else {
				File[] content = file.listFiles();
				for (File f : content) {
					if(f.isFile())
						System.out.println("File: " + f.getName());
					else
						deep(new File(f.getPath()));
							
				}
			}
		}else {
			System.out.println("File does not exist.");
		}
	}

}
