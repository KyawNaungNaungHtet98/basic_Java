package day3;

import java.util.Scanner;

public class Loop_assignment2 {
		void sleep_time() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter time which go to bed : ");
		int sleep = sc.nextInt();
		System.out.print("Enter time which get up bed : ");
		int wake = sc.nextInt();
		int sleep_time = sleep-wake;
		if(sleep_time>= 5 && sleep_time<=8) {
			System.out.println("You take care your health well!");
		}
		else if(sleep_time<5) {
			System.out.println("You are very hardworking");
		}
		else {
			System.out.println("You are abnormal!");
		}
		System.out.print("You wanna try again ???\n pls enter 1 : ");
		int num = sc.nextInt();
		if(num==1) {
			sleep_time();
		}
		else {
			System.out.println("System is exited");
		}
		sc.close();
	}
	public static void main(String[] args){
		Loop_assignment2 obj = new Loop_assignment2();
		obj.sleep_time();
	}
}
