package day10.inheritance;

public class Demo {
	public static void main(String[] args) {
		Person p1 = new Person("James");
		p1.showInfo();
		
		Teacher p2 = new Teacher("Jeon", "Tutor");
		p2.showInfo();
		
		Person p3 = new Teacher("David", "Lecturer");
		p3.showInfo();
	}
}
