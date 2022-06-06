package day11.assignment.assg1;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Student[] array = new Student[4];
		Scanner sc = new Scanner(System.in);
		try {
			for (var i = 0; i < 4; i++) {
				System.out.print("Please enter Student Id : ");
				int num = Integer.parseInt(sc.nextLine());
				System.out.print("Please Enter Student Name : ");
				String name = sc.nextLine();
				System.out.print("Please Enter Student mark : ");
				int mark = Integer.parseInt(sc.nextLine());
				array[i] = new Student(num, name, mark);
				System.out.println();
			}
			for (var i = 0; i < 4; i++) {
				array[i].display();
				System.out.println();
			}
			System.out.print("Please Enter Student id : ");
			int num1 = Integer.parseInt(sc.nextLine());
			System.out.println();
			boolean condition = false;
			for (var i = 0; i < 4; i++) {
				if (num1 == array[i].getStudentId()) {
					array[i].display();
					condition = true;
					break;
				}
			}
			if (!condition) {
				System.out.println("This Student Id  " + num1 + "is not exited");
			}
			System.out.println();
			int max = 0;
			int total = 0;
			int average = 0;
			for (var i = 0; i < 4; i++) {
				if (max < array[i].getMark() || max == array[i].getMark()) {
					max = array[i].getMark();
					array[i].display();
				}
				total += array[i].getMark();
			}
			System.out.println();
			average = total / 4;
			System.out.println("Average mark of all student : " + average);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			sc.close();
		}

	}// main block
}// class block
