package day14;

import java.util.TreeMap;

public class TreeMap_1 {
	public static void main(String[] args) {
		var fileExtension = new TreeMap<String, String>();
		fileExtension.put("Java", ".java");
		fileExtension.put("Php", ".php");
		fileExtension.put("C++", ".cpp");
		fileExtension.put("HTML", ".html");
		fileExtension.put("Javascript", ".js");
		
		System.out.println(fileExtension);
		fileExtension.remove("C++");
		System.out.println(fileExtension);
	}
}
