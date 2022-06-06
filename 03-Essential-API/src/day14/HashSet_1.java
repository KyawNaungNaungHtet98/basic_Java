package day14;

import java.util.HashSet;
import java.util.Set;

public class HashSet_1 {
	public static void main(String[] args) {
		HashSet<String> set1 = new HashSet<>();
		//add
		set1.add("Orange");
		set1.add("Apple");
		set1.add(null);
		set1.add("Mango");
		set1.add("Strawberry");
		
		System.out.println(set1);
		
		//remove
		set1.remove("Apple");
		System.out.println(set1);
		
		Set<String> set2 = Set.of("Patota","Pineapple");
		set1.addAll(set2);
		System.out.println(set1);
		
	}
}
