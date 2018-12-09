import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SuperFastCopy {

	public static void main(String[] args) {
		FileInputStream inFile = null;
		FileOutputStream outFile = null;
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		
		try {
			inFile = new FileInputStream("C:\\Users\\Public\\Videos\\Sample Videos\\Wildlife.wmv");
			outFile = new FileOutputStream("C:\\Users\\Public\\Videos\\Sample Videos\\Wildlife1.wmv");
			inChannel = inFile.getChannel();
			outChannel = outFile.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024*16); //allocate the memory in the JVM for both reading and writing
			long ms1 = System.currentTimeMillis();
			while(true){
				int count = inChannel.read(buffer);
				if(count == -1)break;
				buffer.flip();
				outChannel.write(buffer);
				buffer.clear();
				}
			long ms2 = System.currentTimeMillis();
			System.out.println("File copied successfully in " + (ms2 - ms1) + " ms");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				inChannel.close();
				outChannel.close();
				inFile.close();
				outFile.close();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
	}

}
