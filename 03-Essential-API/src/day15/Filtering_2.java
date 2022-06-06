package day15;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Filtering_2 {
	public static void main(String[] args) {
		Stream<Integer> number = Stream.iterate(1, i -> i+1).limit(15);
		Predicate<Integer> even = x -> x%2 == 0;
		number.filter(a->a>=4 && a<=10).filter(even).forEach(System.out::println);
	}
}
