package day11.assignment.assg1;

public class Student {
	private int studentId;
	private String name;
	private int mark;

	// getter and setter
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	// constructor
	public Student(int studentId, String name, int mark) {
		this.studentId = studentId;
		this.name = name;
		this.mark = mark;
	}

	void display() {
		System.out.println("Student Id : " + getStudentId());
		System.out.println("Name of student : " + getName());
		System.out.println("Mark of student : " + getMark());
	}

}// class block
