package day3;

import java.util.Scanner;

public class SwitchStatment {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter food name : ");
		String name = sc.nextLine();
		String category ;
		// switch statement
//		switch(name) {
//			case"burger","pizza","sandwich":
//				category = "Fast Food";
//				break;
//			case"yougurt","milk tea":
//				category = "Dessert";
//				break;
//			case"mohinga":
//				category = "Burmese Food";
//				break;
//			case"sushi":
//				category = "Japanese Food";
//				break;
//			default:
//				category = "unknown";
//		}
		// switch expression
//		category = 
//			switch(name) {
//			case"burger","pizza","sandwich"->"Fast Food";
//			case"yougurt","milk tea"->"Dessert";
//			case"mohinga"->"Burmese Food";
//			case"sushi"->"Japanese Food";
//			default->"unknown";
//			};
		// switch expression with (yield == return)
		category = 
				switch(name) {
				case"burger","pizza","sandwich"->{
					if(name.equals("pizza"))
						System.out.println(name + " is a Italian Food ");
					yield"Fast Food";
				}
				case"yougurt","milk tea"->{yield"Dessert";}
				case"mohinga"->"Burmese Food";
				case"sushi"->"Japanese Food";
				default->"unknown";
				};
		System.out.print(name + " is "+category);
		sc.close();
	}
}
