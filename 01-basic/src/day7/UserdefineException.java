package day7;

import java.util.Scanner;

public class UserdefineException {
	static void validateAge(int age) throws InvalidAgeException {
		if(age < 18) {
			throw new InvalidAgeException("age is not valid to smoke");
		} else {
			System.out.println("You can smoke");
		}
	}
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Your age : ");
			int age = sc.nextInt();
			validateAge(age);
			sc.close();
		} catch (InvalidAgeException e) {
			System.err.println(e.getMessage());
		}
	}
}
