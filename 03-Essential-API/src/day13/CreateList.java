package day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateList {
	public static void main(String[] args) {
		//array sentences => data type[] name = new data[]{size};
		
		System.out.println("---Cannot be modify---");
		List<Integer> list1 = List.of();//cannot change 
		System.out.println("List : " + list1);
		List<Integer> list2 = List.of(100,200,300);//cannot change 
		System.out.println("List2 : " + list2);
		System.out.println("---Array to list---");
		//array to list
		Integer[] data = {1,2,3,4};
		List<Integer> list3 = Arrays.asList(data);
		System.out.println("List3 : " + list3);
		
		
		System.out.println("---Can be modify list ---");
		//create new list , can be modify
		List<String> list4 = new ArrayList<>();	
		list4.add("Aung Aung");
		System.out.println("List4: " + list4);
		
		//create new list with existing list ==> can be modify
		List<Integer> list5 = new ArrayList<>(Arrays.asList(data));
		list5.add(100);
		System.out.println("List5 : " + list5);
		
		var list6 = new ArrayList<String>();
		list6.add("Mg Mg");
		System.out.println("list6 with var " + list6);
	}
}
