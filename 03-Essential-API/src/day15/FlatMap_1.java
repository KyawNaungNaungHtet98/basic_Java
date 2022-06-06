package day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap_1 {
	public static void main(String[] args) {
		List<String> drinks = Arrays.asList("Cola", "Milk Tea", "Pessi");
		List<String> foods = List.of("Burger", "Noodles", "Cake");
		List<String> desserts = List.of("Ice Cream", "Cake");

		List<List<String>> lists = new ArrayList<>();
		lists.add(drinks);
		lists.add(foods);
		lists.add(desserts);
		System.out.println(lists);
		List<String> flatlist = lists.stream().flatMap(value -> value.stream()).collect(Collectors.toList());
		System.out.println(flatlist);
	}
}
