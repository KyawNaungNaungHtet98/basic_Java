package day18;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WritingWithChannel {
	public static void main(String[] args) {
		String data = """
				FileChannel can be faster than
				Standard I/O if you're dealing with large files.
				""";
		try(RandomAccessFile inputFile = new RandomAccessFile("data.txt", "rw");
				FileChannel channel = inputFile.getChannel()
			) {
			byte[] byteData = data.getBytes();
			ByteBuffer buffer = ByteBuffer.allocate(byteData.length);
			buffer.put(byteData);
			buffer.flip();
			channel.write(buffer);
			System.out.println("saved");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
