package day14.assignment;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Map_Assignment {
	public static void main(String[] args) {
		Map<Integer, Student> students = new LinkedHashMap<>();
		students.put(1001, new Student(1001, "Kyaw Kyaw"));
		students.put(1002, new Student(1002, "Naung Naung"));
		students.put(1003, new Student(1003, "Htet Htet"));
		students.put(1004, new Student(1004, "Maung Maung"));
		students.put(1005, new Student(1005, "Aung Aung"));
		students.forEach((k, v) -> {
			System.out.println(v);
		});
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter For Update Student Information");
			System.out.print("Enter Name : ");
			String name = sc.nextLine();
			System.out.print("Enter Rno : ");
			int rno = Integer.parseInt(sc.nextLine());
			boolean condition = true;
			for (var a : students.keySet()) {
				if (a == rno) {
					System.out.println("This roll number is already existed. ");
					condition = false;

				}
			}
			if (!condition) {
				students.forEach((k, v) -> {
					System.out.println(v);
				});
				System.out.print("Enter Name : ");
				String name_1 = sc.nextLine();
				System.out.print("Enter Rno : ");
				int rno_1 = Integer.parseInt(sc.nextLine());
				students.put(rno_1, new Student(rno_1, name_1));
				students.forEach((k, v) -> {
					System.out.println(v);
				});
			}
			if (condition) {
				students.putIfAbsent(rno, new Student(rno, name));
				students.forEach((k, v) -> {
					System.out.println(v);
				});
			}

			System.out.print("Please Enter 'Role No'  for searching Student Info : ");
			int rno_2 = Integer.parseInt(sc.nextLine());
			students.forEach((k, v) -> {
				if (rno_2 == k) {
					System.out.println(v);
				}
			});
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			sc.close();
		}

	}
}
