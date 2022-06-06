package day10.inheritance;

public class Person {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public void showInfo() {
		System.out.println("Name: " + name);
	}
}
