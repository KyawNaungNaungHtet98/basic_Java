package assignment.assig2;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assignment {
	public static void main(String[] args) {
		var empList = List.of(new Employee("Htet Htet", "Yangon", "Electronics", 900000, LocalDate.parse("1991-10-16")),
				new Employee("Cherry", "Yangon", "Electronics", 820000, LocalDate.parse("1994-08-14")),
				new Employee("Kyaw Kyaw", "Yangon", "Electronics", 780000, LocalDate.parse("1988-09-02")),
				new Employee("Aung Aung", "Mandalay", "IT", 600000, LocalDate.parse("1995-01-11")),
				new Employee("Jeon", "Mandalay", "IT", 600000, LocalDate.parse("1997-09-01")),
				new Employee("Hsu Hsu", "Pyin Oo Lwin", "IT", 920000, LocalDate.parse("1994-12-10")),
				new Employee("Aye Aye", "Yangon", "HR", 500000, LocalDate.parse("1992-10-10")),
				new Employee("Gay Gay", "Taung Gyi", "HR", 400000, LocalDate.parse("1996-05-12")),
				new Employee("Phway Phway", "Monywa", "HR", 300000, LocalDate.parse("1995-09-03")),
				new Employee("Ko Ko", "Monywa", "IT", 500000, LocalDate.parse("1992-11-11")));

		Employee min_salary = empList.stream().min(Comparator.comparingInt(e -> e.getSalary())).get();
		System.out.println(min_salary.getName() + "\t" + min_salary.getDepartment() + "\t" + min_salary.getSalary());

		LocalDate Info = empList.stream().map(s -> s.getBirthday()).max(Comparator.comparing(LocalDate::toEpochDay))
				.get();
		System.out.println(Info);

		empList.stream()
				.filter(s -> s.getBirthday().equals(LocalDate.parse("1995-02-12"))
						|| s.getBirthday().isBefore(LocalDate.parse("1995-02-12")))
				.forEach(s -> System.out.println(s.getName() + "\t" + s.getBirthday()));

		int total = empList.stream().mapToInt(s -> s.getSalary()).sum();
		System.out.println("Total salary : " + total);

		empList.stream().limit(3).forEach(s -> System.out.println(s.getName() + "\t" + s.getSalary()));

		Double average = empList.stream().filter(s -> s.getDepartment().equalsIgnoreCase("HR"))
				.mapToInt(s -> s.getSalary()).average().getAsDouble();
		System.out.println("HR department of average salary" + average);

		String emp = empList.stream().min(Comparator.comparingInt(e -> e.getSalary())).map(e -> e.getName()).get();
		System.out.println("Employee who is smallest salary : " + emp);

		Map<String, List<Employee>> groupByCity = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
		groupByCity.forEach((k, v) -> {
			System.out.println(k);
			var a = v.stream().max(Comparator.comparing((e -> e.getSalary()))).get();
			System.out.println(a.getName() + " \t" + a.getDepartment() + "\t" + a.getSalary());
		});

		Map<Integer, List<Employee>> groupBySalary = empList.stream()
				.collect(Collectors.groupingBy(Employee::getSalary));
		groupBySalary.forEach((k, v) -> {
			System.out.println(k + " ks.");
			v.forEach(a -> System.out.println("\t" + a.getName() + "(" + a.getCity() + ")"));
		});

		Map<String, List<String>> groupByDepartment = empList.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(groupByDepartment);
	}
}
