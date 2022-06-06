package day14;

import java.util.HashMap;
import java.util.Map;

public class HashMap_2 {
	public static void main(String[] args) {
		Map<Integer, Employee> employees = new HashMap<>();
		employees.put(1001, new Employee(1001, "Nyi Nyi", "Yangon"));
		employees.put(1002, new Employee(1002, "Htet Htet", "Pyin Oo Lwin"));
		employees.put(1003, new Employee(1003, "Naung Naung", "Yangon"));
		employees.put(1004, new Employee(1004, "Aung Aung", "Mandalay"));

		employees.forEach((k, v) -> {
			System.out.println(v.getId() + " , " + v.getName() + " , " + v.getCity());
		});
		Employee emp = employees.get(1004);
		System.out.println(emp);
		System.out.println("---City Yangon---");
		employees.forEach((k, v) -> {
			if (v.getCity().equalsIgnoreCase("yangon")) {
				System.out.println(v);
			}
		});

	}//main block
}// class block

class Employee {
	private int id;
	private String name;
	private String city;

	public Employee(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", city=" + city + "]";
	}

}