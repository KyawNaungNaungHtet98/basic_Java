package day6;

import java.util.Scanner;

public class NRC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Please enter your NRC : ");
			String Nrc = sc.nextLine();
			int num1 = Nrc.indexOf("/");
			int num2 = Nrc.indexOf("(");
			int num3 = Nrc.indexOf(")");
			String township = Nrc.substring(num1 + 1, num2);
			String number = Nrc.substring(num3 + 1);
			System.out.println("Township : " + township);
			System.out.println("Number : " + number);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			sc.close();
		}
	}
}
