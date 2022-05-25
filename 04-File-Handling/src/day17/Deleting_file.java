package day17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Deleting_file {
	public static void main(String[] args) throws IOException {
		//delete file
		Path path = Path.of("src/readme.txt");
//		Files.delete(path);
		if(Files.deleteIfExists(path)) {System.out.println("File is delete");}
			
	}
}
