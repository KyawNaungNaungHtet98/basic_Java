package day17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Deleting_Directory {
	public static void main(String[] args) throws IOException {
		//delete empty directory
		Path path = Path.of("./test");
		//System.out.println((Files.deleteIfExists(path)) ? "Deleted" : "Fail");
		
		//delete non-empty
		path = Path.of("src/day12");
		if(Files.exists(path)) {
			Files.walk(path)
			.map(p-> p.toFile()).forEach(f-> f.delete());
		}
		Files.delete(path);
	}
}
