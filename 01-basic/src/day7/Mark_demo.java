package day7;

import java.util.Scanner;

public class Mark_demo {
	static void validateMark(int mark) throws student_mark_exception {
		if(mark < 0 || mark > 100) {
			throw new student_mark_exception("Marks is not true");
		} else {
			System.out.println("Input mark is successed");
		}
	}
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Your Mark : ");
			int mark = sc.nextInt();
			validateMark(mark);
			sc.close();
		} catch (student_mark_exception e) {
			System.err.println(e.getMessage());
		}
		
	}//Main block
}// class block
