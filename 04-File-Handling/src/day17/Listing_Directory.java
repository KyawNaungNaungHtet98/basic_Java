package day17;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Listing_Directory {
	public static void main(String[] args) {
		//Files.list
		Path path = Path.of(".");
		try (Stream<Path> fileList = Files.list(path)) {
			fileList.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("---With walk() method ---" );
		try (Stream<Path> filelist = Files.walk(path)){
			filelist.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
