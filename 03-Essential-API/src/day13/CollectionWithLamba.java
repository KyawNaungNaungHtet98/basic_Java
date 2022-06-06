package day13;

import java.util.List;

public class CollectionWithLamba {
	public static void main(String[] args) {
		List<String> list = List.of("HTML","Css","Js","php","java");
		System.out.println("---With Lamba expression---");
		list.forEach((str)->System.out.println(str));
		
		System.out.println("--------------------");
		list.forEach((str)->{
			if(str.contains("java")) {
				System.out.println(str);
			}
		});
	}
}
