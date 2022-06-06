package day2;

import java.util.Scanner; // import Scanner class 

public class Constant_variable {
	static final float RATE = 1.5f; //declare constant variable
	static final int MIN_PRICE = 1000; //declare constant variable
	float number = 1.5f; // declare float variable
	public static void main(String[] args) {
		//user input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Price :");
		int price = sc.nextInt();
		if(price < MIN_PRICE)
			price = MIN_PRICE;
		System.out.println("Price "+ price);
		System.out.println("Expense " + (price * RATE));
		sc.close();
		
	}
}
