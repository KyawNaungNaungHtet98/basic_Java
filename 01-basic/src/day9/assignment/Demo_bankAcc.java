package day9.assignment;

import java.util.Scanner;

public class Demo_bankAcc {
	public static void main(String[] args) throws InsufficientAmount_Exception {
		Scanner sc = new Scanner(System.in);
		BankAccount obj = new BankAccount(001, "Naung Naung", "001Naung", 100000);
		try {
			System.out.println("1.Deposit\n2.withdraw\n3.change Password\n4.Display Information");
			System.out.print("Please choose : ");
			int num = Integer.parseInt(sc.nextLine());
			if (num == 1) {
				System.out.print("Enter Your deposit amount : ");
				int dep_amount = Integer.parseInt(sc.nextLine());
				obj.deposit(dep_amount);
				System.out.println("Current Balance is " + obj.balance);
			} else if (num == 2) {
				System.out.print("Enter Your withdraw amount : ");
				int withdraw_amount = Integer.parseInt(sc.nextLine());
				obj.withdraw(withdraw_amount);
			} else if (num == 3) {
				obj.changePassword();
			} else {
				obj.showInfo();
			}
		} catch (ArithmeticException e) {
			System.err.println(e.getMessage());
		} catch (InsufficientAmount_Exception e) {
			System.err.println("Error is " + e.getMessage());
		} finally {
			sc.close();
		}

	}// main block
}// class block
