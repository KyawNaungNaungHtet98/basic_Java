package day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Writing_1 {
	public static void main(String[] args) throws IOException {
		List<String> cities = List.of("Yangon","Mandalay","Pyin Oo Lwin");
		Path path = Path.of("city_1.txt");
		Files.write(path, cities);
		Files.write(path, "Monywa".getBytes(), StandardOpenOption.APPEND);
		System.out.println("data saved");
	}
}
