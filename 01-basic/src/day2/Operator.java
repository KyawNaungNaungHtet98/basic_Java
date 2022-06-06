package day2;

public class Operator {
	
	public static void main(String[] args) {
		int num1 = 100;
		int num2 = 200;
		
		System.out.println("num1 + num2 = " + (num1+num2));
		System.out.println("num1 > num2 : " + (num1 > num2));
		System.out.println("Logical Operator (&&) :" + (80 % 5 == 0 && 80 % 8==0));
		
		String result = (18%2 == 1)? "odd" : "even";
		System.out.println("Result : " + result);
		
		num1 += 300;
		System.out.println("Assignment Operator : " + num1);
	}
}
