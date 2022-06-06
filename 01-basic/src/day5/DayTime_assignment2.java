package day5;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DayTime_assignment2 {
	String[] townships = { "AA", "BB", "CC", "DD" };
	int[] times = { 15, 30, 10, 45 };
	String[] menus = { "Pizza", "Burger", "Milk Tea", "Spicy Noodle" };

	// Methods
	public void showMenus() {
		for (var r = 0; r < 4; r++) {
			System.out.println(r + 1 + " ." + menus[r]);
		}
	}

	public void showTownships_Time() {
		for (var r = 0; r < 4; r++) {
			System.out.println(r + 1 + " ." + townships[r] + "(" + times[r] + " mins)");
		}

	}

	public void showOrder() {
		System.out.println("1. Order Now?");
		System.out.println("2. Preorder?");
	}

	public void orderInfo(int a, int b) {
		LocalTime time = LocalTime.now();
		System.out.println("****** Your Order Information ******");
		System.out.println("Item name : " + menus[a - 1]);
		System.out.println("Your address " + townships[b - 1]);
		System.out.println("Duration : " + times[b - 1] + " mins");
		int num = times[b - 1];
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("hh-mm-ss a");
		System.out.println("Arrival Time : " + f2.format(time.plusMinutes(num)));
		System.out.println("******** Thank you for your ordering *******");

	}

	public void preorderInfo(int a, int b, int c) {
		LocalDate date = LocalDate.now();
		System.out.println("****** Your Order Information ******");
		System.out.println("Item name : " + menus[a - 1]);
		System.out.println("Your address " + townships[b - 1]);
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
		System.out.println("Arrival Time : " + f1.format(date.plusDays(c)));
		System.out.println("******** Thank you for your ordering *******");

	}

	public static void main(String[] args) {
		DayTime_assignment2 obj = new DayTime_assignment2();
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("****** Available Menu *******");
			obj.showMenus();
			System.out.print("Please choose item (1 to 4) : ");
			int num = sc.nextInt();
			System.out.println("***** Deliverable Township ******");
			obj.showTownships_Time();
			System.out.print("Please choose item (1 to 4) : ");
			int num1 = sc.nextInt();
			System.out.println("****** Order Type *****");
			obj.showOrder();
			System.out.print("Please choose item (1 to 2) : ");
			int num2 = sc.nextInt();
			if (num2 == 1) {
				obj.orderInfo(num, num1);
			} else {
				System.out.print("Enter Preorder day : ");
				int num3 = sc.nextInt();
				obj.preorderInfo(num, num1, num3);
			}

		} catch (Exception e) {
			System.err.print("Please retry with 1 to 4");
		} finally {
			sc.close();
		}

	}

}
