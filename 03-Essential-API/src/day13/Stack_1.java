package day13;

import java.util.Stack;

public class Stack_1 {
	public static void main(String[] args) {
		var city = new Stack<>();
		//add elements
		city.push("Yangon");
		city.push("Mdy");
		city.push("Pyin OO Lwin");
		
		System.out.println(city);
		
		city.pop();//remove last element
		System.out.println(city);
	}
}
