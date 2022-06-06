package day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Stream_1 {
	public static void main(String[] args) {
		int[] price = { 1700, 400, 6000, 700, 1000, 2000, 3000, 1600 };
		System.out.println("---With Stream API");
		// create stream
		IntStream streams = Arrays.stream(price);
		streams.filter(p -> p > 1000).sorted().forEach(p -> System.out.println(p));

		System.out.println("--Without Stream API---");
		var list = new ArrayList<Integer>();
		// filter
		for (var p : price) {
			if (p > 1500) {
				list.add(p);
			}
		}
		// sorted
		Collections.sort(list);
		for (var p : list) {
			System.out.println(p);
		}
	}
}
