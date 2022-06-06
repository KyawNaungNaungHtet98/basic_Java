package day9.assignment;

import java.util.Scanner;

public class BankAccount {
	int accountNo;
	String holderName;
	private String pinNo = "1001";
	String password;
	int balance;

	public BankAccount(int accountNo, String holderName, String password, int balance) {
		super();
		this.accountNo = accountNo;
		this.holderName = holderName;
		this.password = password;
		this.balance = balance;
	}

	public void setpinNO(String pinNo) {
		this.pinNo = pinNo;
	}

	public String getpinNo() {
		return this.pinNo;
	}

	void deposit(int balance) {
		this.balance += balance;
	}

	void withdraw(int balance) throws InsufficientAmount_Exception {
		if (this.balance < balance) {
			throw new InsufficientAmount_Exception("Your balance is not enough.\nYour balance is " + this.balance);
		} else {
			System.out.println("Before withdraw , Your balance is :" + this.balance);
			this.balance -= balance;
			System.out.println("Current balance is : " + this.balance);
		}
	}

	void changePassword() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Pin Number : ");
		String num = sc.nextLine();
		if (num.equals(this.pinNo)) {
			System.out.print("Please enter new password : ");
			String new_pass = sc.nextLine();
			this.password = new_pass;
		} else {
			System.out.println("Please retry with correct Pin number  ");
			changePassword();
		}
		sc.close();
	}

	void showInfo() {
		System.out.println("Account Number : " + this.accountNo);
		System.out.println("Holder Name : " + this.holderName);
		System.out.println("Balance : " + this.balance);
	}
}// class block
