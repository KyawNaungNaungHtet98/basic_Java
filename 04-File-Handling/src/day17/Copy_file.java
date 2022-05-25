package day17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Copy_file {
	public static void main(String[] args) throws IOException {
		Path source = Path.of("src/readme.txt");
		Path dest = Path.of("src/another.txt");
//		Files.copy(source, dest,StandardCopyOption.REPLACE_EXISTING);
		Files.move(source, dest, StandardCopyOption.REPLACE_EXISTING);//cut
		System.out.println("Copied");
	}
}
