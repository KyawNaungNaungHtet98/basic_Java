package day15;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping_1 {
	public static void main(String[] args) {
		List<Employee> employees = List.of(new Employee("Kyaw Kyaw", 9800, "Yangon"),
				new Employee("Aung Aung", 6000, "Mandalay"), new Employee("Mg Mg", 10000, "Mandalay"),
				new Employee("Yuri", 6000, "Yangon"), new Employee("Jeon", 7800, "Monywa"));
		// count
		Map<String, Long> counting = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getCity(), Collectors.counting()));
		System.out.println(counting);

		// sum
		Map<String, Integer> sum = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getCity(), Collectors.summingInt(e -> e.getSalary())));
		System.out.println(sum);

		// average
		Map<String, Double> avg = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getCity(), Collectors.averagingDouble(e -> e.getSalary())));
		System.out.println(avg);

		// group by salary
		Map<Integer, List<Employee>> groupBySalary = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getSalary()));
		groupBySalary.forEach((k, list) -> {
			System.out.println(k + "ks.");
			list.forEach(e -> {
				System.out.println("\t" + e.getName() + "(" + e.getCity() + ")");
			});
		});

		// names of each city
		Map<String, List<String>> groupByCity = employees.stream().collect(
				Collectors.groupingBy(e -> e.getCity(), Collectors.mapping(e -> e.getName(), Collectors.toList())));
		System.out.println(groupByCity);

		// Same City
		Map<String, List<Employee>> data = employees.stream()
				.collect(Collectors.collectingAndThen(Collectors.groupingBy(e -> e.getCity()), // city = list
						map -> map.entrySet().stream().filter(e -> e.getValue().size() > 1)
								.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()))));
		data.forEach((city,list)-> {
			System.out.println(city);
			list.forEach(emp-> {
				System.out.println("\t" + emp.getName() + "(" + emp.getCity() + ")");
			});
		});
	}
}
