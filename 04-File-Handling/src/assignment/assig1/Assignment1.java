package assignment.assig1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment1 {
	public static void main(String[] args) {
		var salePeople = List.of(new SalePeople("Peel", "London", 0.12), new SalePeople("Serres", "San Jose", 0.13),
				new SalePeople("Motika", "London", 0.11), new SalePeople("Rifkin", "Barcelona", 0.15),
				new SalePeople("Axelrod", "New York", 0.10));
//		1. Names and cities of all salespeople in London with a commission above .10.
		System.out.println("Names and cities of all salespeople in London with a commission above .10.");
		salePeople.stream().filter(s -> (s.getCity().equalsIgnoreCase("london")) && (s.getCommision() > 0.10))
				.forEach(s -> System.out.println("Name : " + s.getName() + " , City : " + s.getCity()));
//		2. Salesperson details not having commission .10, .13 or .15.
		System.out.println("\nSalesperson details not having commission .10, .13 or .15.");
		salePeople.stream()
				.filter(s -> (s.getCommision() != 0.10) && (s.getCommision() != 0.13) && (s.getCommision() != 0.15))
				.forEach(s -> System.out.println(
						"Name : " + s.getName() + " , City : " + s.getCity() + " , Commision" + s.getCommision()));
//		3. Different city names.
		System.out.println("\nDifferent city names.");
		salePeople.stream().map(s -> s.getCity()).distinct().forEach(s -> System.out.println(s));
//		4. The top of (salespeople 3) records.
		System.out.println("\nThe top of (salespeople 3) records.");
		salePeople.stream().limit(3).forEach(s -> System.out.println(s));
//		5. Details of the salespeople who live in ‘Rome’.
		System.out.println("\nDetails of the salespeople who live in ‘Rome’.");
		salePeople.stream().filter(s -> s.getCity().equalsIgnoreCase("rome")).toList();
//		6. The number of salespeople who stay in London.
		System.out.println("\nThe number of salespeople who stay in London.");
		var count = salePeople.stream().filter(s -> s.getCity().equalsIgnoreCase("london")) .collect(
				Collectors
				 .groupingBy(e -> e.getCity(),Collectors.counting())
				 );
		System.out.println(count);
//		7. List of salespeople in descending order of commission
		System.out.println("\nList of salespeople in descending order of commission");
//		salePeople.stream().mapToDouble(s->s.getCommision()).reverse().forEach(s->System.out.println(s));
		salePeople.stream().mapToDouble(s->s.getCommision()).sorted().forEachOrdered(s-> System.out.println(s));
}
}
