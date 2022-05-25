package day18;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadingWithChannel {
	public static void main(String[] args) {
		try (RandomAccessFile inputFile = new RandomAccessFile("src/employee.txt", "r");
				FileChannel channel = inputFile.getChannel()){
			long fileSize = channel.size();//file size
			//create bytes buffer
			ByteBuffer buffer = ByteBuffer.allocate((int)fileSize);
			//read file to buffer
			channel.read(buffer);
			//prepare to read from buffer
			buffer.flip();
			String data = new String(buffer.array(),0,buffer.limit());
			System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
