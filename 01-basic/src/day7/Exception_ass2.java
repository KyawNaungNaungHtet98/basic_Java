package day7;

import java.util.Scanner;

public class Exception_ass2 {
	public static void main(String[] args) {
		String[] division = {"AA", "BB", "CC", "DD", "EE", "FF","GG", "HH","II", "JJ", "KK",
				"LL", "MM", "NN"};
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Please enter your NRC : ");
			String Nrc = sc.nextLine();
			int num1 = Nrc.indexOf("/");
			int num2 = Nrc.indexOf("(");
			int num3 = Nrc.indexOf(")");
			String township = Nrc.substring(num1 + 1, num2);
			String number = Nrc.substring(num3 + 1);
			String station = Nrc.substring(0,num1);
			int num4 = Integer.parseInt(station);
			System.out.println(division[num4-1]);
			System.out.println("Station : " + station);
			System.out.println("Township : " + township);
			System.out.println("Number : " + number);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("NRC is not correct");
		} finally {
			sc.close();
		}
	}// main block
}//class block
