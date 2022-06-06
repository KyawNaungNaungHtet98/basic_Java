package day14;

import java.util.LinkedHashMap;

public class LinkHashMap_1 {
	public static void main(String[] args) {
		var students = new LinkedHashMap<Integer, String>();
		students.put(1, "Aung Aung");
		students.put(11, "Kyaw Kyaw");
		students.put(5, "Honey");
		students.putIfAbsent(10, "Cherry");
		students.forEach((k,v)-> System.out.format("Role : %s , name : %s\n",k,v));
		System.out.println();
		students.replace(5, "May Oo May");
		System.out.println(students.get(5));
		students.remove(11);
		System.out.println(students);
	}
}
