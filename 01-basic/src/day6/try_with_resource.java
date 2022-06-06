package day6;

import java.util.Scanner;

public class try_with_resource {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter your name : ");
			String name = sc.nextLine();
		} catch (Exception e) {
			System.out.println("It is error ");
		}

	}
}
