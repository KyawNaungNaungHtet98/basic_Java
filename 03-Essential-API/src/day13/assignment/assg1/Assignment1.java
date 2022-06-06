package day13.assignment.assg1;

import java.util.ArrayList;
import java.util.Collections;

public class Assignment1 {
	public static void main(String[] args) {
		// a
		var students = new ArrayList<String>();
		students.add("Aung Aung");
		students.add("Ko Ko");
		students.add("Naung Naung");
		students.add("Kmol");
		students.add("Maung maung");

		// b
		System.out.println("---Sorting---");
		Collections.sort(students);
		// c
		System.out.println(students);

		// d
		int result = Collections.binarySearch(students, "Kmol");
		System.out.println("Position of Kmol is : index ( " + result + " )");
		System.out.println("Searching with index : " + students.get(2));

		// e
		int num = Collections.binarySearch(students, "naung naung");
		if (num < 0) {
			students.add("naung naung");
			Collections.sort(students);
			System.out.println(students);
		} else {
			System.out.println(students.get(num));
		}

		// f
		System.out.println("---searching---");
		students.forEach(s -> {
			if (s.startsWith("k") || s.startsWith("K")) {
				System.out.println(s);
			}
		});

		// g
		System.out.println("---remove ---");
		students.removeIf(s -> (s.endsWith("G") || s.endsWith("g")));
		System.out.println(students);

		// h
		students.clear();

	}// main block
}// class block
