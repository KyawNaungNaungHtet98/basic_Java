package day13;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList_1 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		//add
		list.add(20);
		list.add(100);
		list.add(50);
		list.add(10);
		
		//size
		System.out.println("Size : " + list.size());
		
		list.add(1, 40);//add with index
		System.out.println("list : " + list);
		
		
		System.out.println("[2]: " + list.get(2));//get element
		
		//update 
		list.set(0, 204);
		System.out.println("After with set : " + list);
		
		//empty ??? 
		System.out.println("Is Empty? : " + list.isEmpty());
		
		//remove
		list.remove(1);
		System.out.println("After remove : " + list);
		System.out.println("After remove , Size : " + list.size());
		
		//searching Max / Min value
		System.out.println("Max value : " + Collections.max(list));
		System.out.println("Min value : " + Collections.min(list));
		
		//clear -> all delete value
		list.clear();
		System.out.println("After clear : " + list.size());
		System.out.println("Is Empty : " + list.isEmpty());
		
	}
}
