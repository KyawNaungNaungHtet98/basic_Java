package day14;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet_1 {
	public static void main(String[] args) {
		TreeSet<String> set1 = new TreeSet<>();
		set1.add("Orange");
		set1.add("Apple");
		//set1.add(null);// null is not allowed in tree set
		set1.add("Mango");
		set1.add("Strawberry");
		
		Iterator<String> itr = set1.iterator();
		itr.forEachRemaining(s-> System.out.println(s));
		
		var set2 = set1.descendingSet();
		System.out.println("\n" + set2);
	}
}
