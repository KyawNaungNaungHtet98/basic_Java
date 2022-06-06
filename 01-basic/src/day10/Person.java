package day10;

public class Person {
	private String name;
	protected String phoneNo;

	public Person(String name, String phoneNo) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
	}
	void display() {
		System.out.println("Name - " + name);
		System.out.println("Phone - " + phoneNo);
	}
}
