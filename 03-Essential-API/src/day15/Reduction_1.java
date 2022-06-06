package day15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Reduction_1 {
	public static void main(String[] args) {
		List<Employee> empList = Arrays.asList(new Employee("Kyaw Kyaw", 9800, "Yangon"),
				new Employee("Aung Aung", 6000, "Mandalay"), new Employee("Mg Mg", 10000, "Mandalay"),
				new Employee("Yuri", 6000, "Yangon"), new Employee("Jeon", 7800, "Monywa"));

		System.out.println("---Built in Reduction ----");

		int total = empList.stream().mapToInt(emp -> emp.getSalary()).sum();
		double average_salary = empList.stream().mapToDouble(emp -> emp.getSalary()).average().getAsDouble();
		int max_sal = empList.stream().mapToInt(emp -> emp.getSalary()).max().getAsInt();
		long count = empList.stream().filter(emp -> emp.getSalary() > 6000).count();
		Employee emp_max = empList.stream().max(Comparator.comparingInt(e -> e.getSalary())).get();
		Employee emp_min = empList.stream().min((e1, e2) -> e1.getSalary() - e2.getSalary()).get();

		System.out.println("Total : " + total);
		System.out.println("Average : " + average_salary);
		System.out.println("Max salary : " + max_sal);
		System.out.println("Count " + count);
		System.out.println("Employee Min Salary : " + emp_min);
		System.out.println("Employee Max salary : " + emp_max);

		System.out.println("---Custom reduction---");
		// use .reduce()
		int total_1 = empList.stream().mapToInt(emp -> emp.getSalary()).reduce(0, (s1, s2) -> s1 + s2);
		System.out.println("Total : " + total_1);
		int min_salary = empList.stream().mapToInt(emp -> emp.getSalary()).reduce(Integer::min).getAsInt();
		System.out.println("Min Salary : " + min_salary);
		Employee emp_max_1 = empList.stream()
				.reduce((emp1, emp2) -> (emp1.getSalary() < emp2.getSalary() ? emp2 : emp1)).get();
		System.out.println("Employee Max salary : " + emp_max_1);
	}
}
