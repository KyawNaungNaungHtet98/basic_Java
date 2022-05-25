package day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
	private int id;
	private String name;
	private String address;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static Employee getEmployeeFromLine(String line) {
		String[] data = line.split("\t");
		Employee emp = new Employee();
		emp.setId(Integer.parseInt(data[0]));
		emp.setName(data[1]);
		emp.setAddress(data[2]);
		return emp;
	}

}

public class Reading_1 {
	public static void main(String[] args) throws IOException {
		List<String> line = Files.readAllLines(Path.of("src/emplist.txt"));
		List<Employee> empList = line.stream().map(Employee::getEmployeeFromLine).collect(Collectors.toList());
		empList.forEach(s -> System.out
				.println("Id : " + s.getId() + "| Name : " + s.getName() + "\t| Address : " + s.getAddress()));
	}
}
