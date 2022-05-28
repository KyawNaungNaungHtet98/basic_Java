package assignment.assig2;

import java.time.LocalDate;

public class Employee {
	private String name;
	private String city;
	private String department;
	private int salary;
	private LocalDate birthday;
	public Employee(String name, String city, String department, int salary, LocalDate birthday) {
		super();
		this.name = name;
		this.city = city;
		this.department = department;
		this.salary = salary;
		this.birthday = birthday;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", city=" + city + ", department=" + department + ", salary=" + salary
				+ ", birthday=" + birthday + "]";
	}
	
}
