package day10;

public class Student extends Person {
	private int rNo;
	public Student(int rno, String name,String phone) {
		super(name,phone);
		this.rNo = rno;
	}
	public int getRno() {
		return this.rNo;
	}
}
