package day9;

public class constructor_chain {
	public constructor_chain() {
		this(7);
		System.out.println("This is default constructor");
	}
	public constructor_chain(int i) {
		this(100,200);
		System.out.println("This is one argument constructor");
	}
	public constructor_chain(int i,int j) {
		System.out.println("i = " + i + " j = " + j);
	}
class Employee {
	private String name;
	Employee() {
		
	}
	Employee(String name) {
		this.name = name;
	}
}
class Teacher extends Employee {
	private String position;
	Teacher(String name, String position) {
		super(name);
		this.position = position;
	}
}
	public static void main(String[] args) {
		constructor_chain obj = new constructor_chain();
	}
}
