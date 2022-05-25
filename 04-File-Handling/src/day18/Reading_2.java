package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Reading_2 {
	public static void main(String[] args) throws IOException {
		System.out.println("---Files.readAllBytes----");
		byte[] data = Files.readAllBytes(Path.of("src/emplist.txt"));
		for(var str : data) {
			System.out.println(str);
		}
		System.out.println(new String(data));

		//Read String
		System.out.println("---Files.ReadString----");
		String value = Files.readString(Path.of("src/emplist.txt"));
		System.out.println(value);
		//read with buffer
		System.out.println("---Reading with BufferReader---");
		try (BufferedReader reader = Files.newBufferedReader(Path.of("src/emplist.txt"))){
			var line = "";
			while((line = reader.readLine()) != null) {
				if(line.contains("Aung")) {
					System.out.println(line);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
