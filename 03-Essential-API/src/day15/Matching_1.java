package day15;

import java.util.List;

public class Matching_1 {
	public static void main(String[] args) {
		var number = List.of(2,4,6,8,10,11);
		boolean AllMatch = number.stream().allMatch(m-> m%2==0);
		boolean AnyMatch = number.stream().anyMatch(m-> m%2==0);
		boolean NoneMatch = number.stream().noneMatch(m-> m%2==0);
		System.out.println("All Match : " + AllMatch);
		System.out.println("Any Match : " + AnyMatch);
		System.out.println("None Match : " + NoneMatch);
		
		
	}
}
