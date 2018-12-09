import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputDemo {
	public static void main(String[] args) {
		String path = "C:\\Users\\Ashwini.Sharma08\\Desktop\\temp.txt";
		FileOutputStream ostream = null;
		
		try {
			ostream = new FileOutputStream(path);
			String line = "Let me take you to the Rio";
			
			byte[] bar = line.getBytes();
			ostream.write(bar);
			System.out.println("Content Written");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(ostream != null)
					ostream.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}
