package day3;

import java.util.Scanner;

public class Loop_assignment1 {
	public static void main(String[] args) {
		int zero = 0;
		int positve = 0;
		int negative = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("How many numbers you want to type : ");
		int number = Integer.parseInt(sc.nextLine());
		for(int i = 0; i<number; i++) {
			System.out.print("Enter number : ");
			int num = Integer.parseInt(sc.nextLine());
			
			if(num == 0)
				zero++;
			else if(num >0)
				positve++;
			else
				negative++;
			};

		
		System.out.println("Numbers of zero :"+ zero);
		System.out.println("Numbers of positive :"+positve);
		System.out.println("Numbers of negative :"+negative);
		sc.close();
	}
}
