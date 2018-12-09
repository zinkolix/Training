import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputDemo {
	public static void main(String[] args) {
		String path = "C:\\Users\\Ashwini.Sharma08\\Desktop\\temp.txt";
		FileInputStream istream = null;
		int c = 0;
		//char ch = '\0';
		try {
			istream = new FileInputStream(path);
			byte[] bar = new byte[istream.available()];
			istream.read(bar);
			String s = new String(bar);
			System.out.println(s);
//			while(true) {
//				c = istream.read();
//				if(c == -1)
//					break;
//				System.out.println((char)c);
//			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally{
			try {
				if(istream != null)
					istream.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}
