package day14;

import java.util.LinkedHashSet;

public class LinkHashSet_1 {
	public static void main(String[] args) {
		LinkedHashSet<String> set1 = new LinkedHashSet<>();
		set1.add("Orange");
		set1.add("Apple");
		set1.add(null);
		set1.add("Mango");
		set1.add("Strawberry");
		
		set1.forEach(s-> System.out.println(s));
		
		set1.remove(null);
		System.out.println(set1);
		
		set1.removeIf(s-> s.contains("o"));
		System.out.println("After remove , " + set1);
		
	}
}
