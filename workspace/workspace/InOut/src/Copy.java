import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {

	public static void main(String[] args) {
		FileInputStream inFile = null;
		FileOutputStream outFile = null;
		try {
			inFile = new FileInputStream("C:\\Users\\Public\\Videos\\Sample Videos\\Wildlife.wmv");
			outFile = new FileOutputStream("C:\\Users\\Public\\Videos\\Sample Videos\\Wildlife1.wmv");
			int ch = 0;
			long ms1 = System.currentTimeMillis();
			while(true){
				ch = inFile.read();
				if(ch == -1) break;
				outFile.write(ch);
			}
			long ms2 = System.currentTimeMillis();
			System.out.println("File copied successfully in " + (ms2-ms1) + "ms" );
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
				try {
					inFile.close();
					outFile.close();
				} catch (IOException e) {
			
					e.printStackTrace();
				}
	}
	}
}

	