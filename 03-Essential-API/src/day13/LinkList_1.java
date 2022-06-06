package day13;

import java.util.LinkedList;

public class LinkList_1 {
	public static void main(String[] args) {
		var list = new LinkedList<>();
		list.add("Nilar");
		list.add(0, "Aung Aung");
		list.add("Kyaw Kyaw");
		System.out.println(list);
		
		list.addFirst("Jeon");
		list.addLast("Cherry");
		
		System.out.println(list);
		System.out.println("[2]" + list.get(2));
		System.out.println("Last element " + list.getLast());
		System.out.println("First Element " + list.getFirst());
	}
}
