package day4;

import java.util.Arrays;

public class TwoDArrays {
	public static void main(String[] args) {
		int[][] marks = {
				{65,74,28,90,100},
				{71,80,90,69,95},
				{56,89,59,88,67}
		};
		
		System.out.println("---For looping with 2D arrays---");
		for(var r=0; r<3; r++) {
			for(var c=0; c<5; c++) {
				System.out.println(marks[r][c]+"\t");
			}
			System.out.println();
			}
		
		
		System.out.println("---for each with 2D arrays---");
		for(int[] rows:marks) {
			for(int col:rows) {
				System.out.println(col+"\t");
			}
			System.out.println();
		}
		System.out.println("Data : "+Arrays.deepToString(marks));
		
		
		}
}
