package day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayList_2 {
	public static void main(String[] args) {
		String[] data = { "Aung Aung", "Jeon", "Yuki", "Maung Maung" };
		ArrayList<String> list = new ArrayList<>(Arrays.asList(data));
		list.add("Jeon");
		System.out.println(list);

		// sorting
		Collections.sort(list);// Ascending
		System.out.println("After sorting : " + list);

		Collections.reverse(list);// Descending
		System.out.println("After sorting : " + list);

		// searching
		int result = Collections.binarySearch(list, "Jeon");
		System.out.println((result < 0) ? "Not Found" : "Found");
		result = Collections.binarySearch(list, "ABC");
		System.out.println((result < 0) ? "Not Found" : "Found");

		if (list.contains("Yuki")) {
			System.out.println("Yuki is Found");
		}

		// remove
		list.remove("Jeon");
		System.out.println("After Removing 'Jeon' : " + list);
		list.removeIf(s -> s.endsWith("ung") && s.length() > 9);
		System.out.println("After Using with removeif : " + list);
	}
}
