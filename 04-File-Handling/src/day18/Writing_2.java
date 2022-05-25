package day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Writing_2 {
	public static void main(String[] args) throws IOException {
		String data = """
				Name	=	Aung Aung
				Address	=	Yangon
				Age		=	26
				""";
		Files.writeString(Path.of("student.txt"), data);
		System.out.println("saved");
	}
}
