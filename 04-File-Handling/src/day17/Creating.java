package day17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Creating {
	public static void main(String[] args) throws IOException {
		//create file
		Path path = Path.of("src/readme.txt");
		if(Files.exists(path)) {
			System.out.println("FILE IS Already existed");
		} else {
			Files.createFile(path);
			System.out.println("Created file");
		}
		
		//create directory
		path = Path.of("./test");
		if(Files.notExists(path)) {
			Files.createDirectories(path);
		}
	}
}
