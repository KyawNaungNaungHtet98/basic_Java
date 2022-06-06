package day4;

import java.util.Scanner;

public class Array_assignment1 {
	String[] name = {"lenovo","hp","samsung","acer","dell","asus"};
	String[] core = {"corei3","corei5","corei7","corei9"};
	double[][] price = {
			{230.21,529.483,552.504,690.63},
			{400.21,920.483,960.504,1200.63},
			{294.2,676.66,706.08,882.6},
			{693.33,1594.659,1663.992,2079.99},
			{340.44,783.012,817.056,1021.32},
			{691.99,1591.577,1660.776,2075.97}
	};
	public void display_name() {
		for(var i = 0; i < 6; i++) {
			System.out.println(i + ". "+name[i]);
		}
	}
	public void display_price(int i) {
		for(var r = 0; r < price.length; r++) {
			for(var c = 0; c< price[0].length; c++) { 
				if(i == r) {
					System.out.println(c+" ." + price[r][c]);
				}
			}
		}
	}
	public void display_core() {
		for(var i = 0; i <= 3; i++) {
			System.out.println(i+" . "+core[i]);
		}
	}
	
	public void showDetail_Price(int a,int b) {
		for(var r = 0; r < price.length; r++) {
			if(a==r) {
				for(var c = 0; c < price[0].length; c++) {
					if(b==c) {
						System.out.println("Price is : " + price[a][b]);
					}
				}
			}
		}
	}
	public double changePriceMMR(int a,int b) {
		double sum;
		double total = 0;
		for(var r = 0; r < price.length; r++) {
			if(a==r) {
				for(var c = 0; c < price[0].length; c++) {
					if(b==c) {
						sum = price[a][b];
						total = sum*1850.65;
					}
				}
			}
		}
		return total;
	}
	
	public static void main(String[] args) {
		Array_assignment1 obj = new Array_assignment1();
		Scanner sc = new Scanner(System.in);
		System.out.println("What do u find?");
		obj.display_name();
		System.out.print("Please choose a Number : ");
		int num = sc.nextInt();
		if(num >=0 && num <=5) {
			System.out.println("\n---The Prices ---");
			obj.display_price(num);
			System.out.println("");
		}else {
			System.out.println("Please retry within '0 to 5'.");
			return;
		}
		System.out.println("Which corei  do u want to find?");
		obj.display_core();
		System.out.print("Please enter number '0 to 3' : ");
		int num1 = sc.nextInt();
		System.out.println("");
		if(num1>=0 && num1<=3) {
			obj.showDetail_Price(num,num1);
		}else {
			System.out.println("Please try with Number '0 to 3 '");
			return;
		}
		System.out.println("");
		double MMR_price = obj.changePriceMMR(num, num1);
		System.out.print("MMR price is ");
		System.out.println(MMR_price);
		sc.close();
	}
}
