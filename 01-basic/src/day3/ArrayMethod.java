package day3;

import java.util.Arrays;

public class ArrayMethod {
	public static void main(String[] args) {
		int[] arr1 = {
				100,20,200,40,90
		};
		
		System.out.println("---all elements from array---");
		for(var a : arr1)
			System.out.println(a+" ");
		
		//copy all
		int[] copyArr1 = Arrays.copyOf(arr1, arr1.length);
		System.out.println("\nAfter Copy " + Arrays.toString(copyArr1));
		
		//copy range
		int[] copyArr2 = Arrays.copyOfRange(arr1, 1, 3);
		System.out.println("\nAfter copy range, "+ Arrays.toString(copyArr2));
		
		System.out.println("arr1 == copyArr1 ->" + Arrays.equals(arr1, copyArr1));
		System.out.println("arr1 == copyArr2 ->" + Arrays.equals(arr1, copyArr2));
		
		//sorting
		Arrays.sort(arr1);
		System.out.println("After sorting " + Arrays.toString(arr1));
		
		//searching with binary search
		//if exit , return positive 
		System.out.println("Is 90 in array??: "+ Arrays.binarySearch(arr1, 90));
		//if not exit, return negative
		System.out.println("Is 900 in array??: "+Arrays.binarySearch(arr1, 900));
		

		
		//Using with stream
		int total = Arrays.stream(arr1).sum();
		System.out.println("Total : "+ total);
		
		//Searching max value with stream
		System.out.println("Max value : "+ Arrays.stream(arr1).max().getAsInt());
		System.out.println("Min value : "+Arrays.stream(arr1).min().getAsInt());
		
		//all array fill to the same
		Arrays.fill(arr1, 7);
		System.out.println("After filling, " +Arrays.toString(arr1));
		changeValue(arr1);
		System.out.println("After changing value, "+Arrays.toString(arr1));
		
		
	}
	
	static void changeValue(int[] input) {
		input[0] = 100;
	}
	
}
