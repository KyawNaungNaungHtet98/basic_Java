package day3;

import java.util.Scanner;

public class ConditionalStatement {
	public static void main(String[] args) {
		//if else statement
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter email : ");
//		String email = sc.nextLine();
//		System.out.print("Enter Password : ");
//		String pass = sc.nextLine();
//		if(email.equals("jk@gmail.com") && pass.equals("jeon")) {
//			System.out.println("Login success");
//			}else {
//			System.err.println("Email and password don't match!");
//			}
//
//		sc.close();
		
		//if else if
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your bmi : ");
		float bmi = sc.nextFloat();
		
		if(bmi<18.5)
			System.out.println("Underweight");
		else if(bmi>=18.5 && bmi<= 24.9)
			System.out.println("Normal weight");
		else if(bmi>=25 && bmi<= 29.9)
			System.out.println("Overweight");
		else
			System.out.println("Obesity");
		sc.close();
	}
}
