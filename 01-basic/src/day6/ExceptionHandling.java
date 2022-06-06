package day6;

import java.util.Scanner;

public class ExceptionHandling {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter number 1 : ");
			int num1 = Integer.parseInt(sc.nextLine());
			System.out.print("Enter number 2 : ");
			int num2 = Integer.parseInt(sc.nextLine());
			int result = num1/num2;
			System.out.println("Result : " + result);
			sc.close();
			
		} catch (ArithmeticException e) {
			System.err.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.err.println("User is not number");
		}
		
		System.out.println("Outside of try-catch clause");
	}
}
