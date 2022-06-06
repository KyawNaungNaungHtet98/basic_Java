package day14.assignment;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Hask_Assignment {
	public static void main(String[] args) {
		var set1 = new LinkedHashSet<Student>();
		set1.add(new Student(1001, "Kyaw Kyaw"));
		set1.add(new Student(1002, "Naung Naung"));
		set1.add(new Student(1003, "Htet Htet"));
		set1.add(new Student(1004, "Maung Maung"));
		set1.add(new Student(1005, "Aung Aung"));
		set1.forEach(s -> System.out.println(s.getRno() + "\t" + s.getName()));

		Scanner sc = new Scanner(System.in);
		try {

			System.out.println("Enter For Update Student Information");
			System.out.print("Enter Name : ");
			String name = sc.nextLine();
			System.out.print("Enter Rno : ");
			int rno = Integer.parseInt(sc.nextLine());
			boolean condition = true;
			for (var num : set1) {
				if (num.getRno() == rno) {
					System.out.println("This roll number is already existed. ");
					set1.stream().forEach(s -> System.out.println(s.getRno()));
					System.out.print("Enter Name : ");
					String name_1 = sc.nextLine();
					System.out.print("Enter Rno : ");
					int rno_1 = Integer.parseInt(sc.nextLine());
					set1.add(new Student(rno_1, name_1));
					condition = false;
					break;
				}
			}
			if (condition)
				set1.add(new Student(rno, name));
			set1.stream().forEach(s -> System.out.println(s.getRno() + "\t" + s.getName()));
			System.out.print("Please Enter 'Role No'  for searching Student Info : ");
			int rno_2 = Integer.parseInt(sc.nextLine());
			if (rno_2 >= 1001 || rno_2 <= 1006) {
				for (var num : set1) {
					if (num.getRno() == rno_2) {
						System.out.println(num.getName());
						break;
					}
				}
			} else {
				System.out.println("This rno is not existed ");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			sc.close();
		}
	}
}
