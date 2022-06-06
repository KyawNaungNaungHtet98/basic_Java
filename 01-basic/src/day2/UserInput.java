package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
	
	public static void main(String[] args) throws IOException {
		//stream (Carry Information)
		//Create 
		//Buffered reader => user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		///Other operation 
		System.out.print("Enter name : ");
		String name = br.readLine();
		System.out.print("Enter salary : ");
		double salary = Double.parseDouble(br.readLine());
		System.out.print("Enter age : ");
		int age = Integer.parseInt(br.readLine());
		//Close 
		br.close();
		System.out.println("\nName : "+ name);
		System.out.println("Salary : "+ salary);
		System.out.println("Age : "+ age);
		
		
	}
}
