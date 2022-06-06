package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment_userInput {
	public static void main(String[] args) throws IOException {
		BufferedReader info = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter Name : ");
		String name = info.readLine();
		
		System.out.print("Enter Email : ");
		String email = info.readLine();
		
		System.out.print("Enter Phone : ");
		String phone = info.readLine();
		
		System.out.print("Enter Education : ");
		String education = info.readLine();
		
		System.out.print("Enter Income : ");
		double income = Double.parseDouble(info.readLine());
		
		System.out.print("Enter age : ");
		int age = Integer.parseInt(info.readLine());
		
		info.close();
		
		System.out.println("\nFullname : "+ name);
		System.out.println("Email : "+ email);
		System.out.println("Phone : "+ phone);
		System.out.println("education : "+ education);
		System.out.println("Income : "+ income);
		System.out.println("Age : "+ age);
	}
}
