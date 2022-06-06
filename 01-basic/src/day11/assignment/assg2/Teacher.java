package day11.assignment.assg2;

public class Teacher extends Person {
	String position;
	String department;
	float salary;

	public Teacher(String name, String nrcno, String address, String phone, String position, String department,
			float salary) {
		super(name, nrcno, address, phone);
		this.position = position;
		this.department = department;
		this.salary = salary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	void promote(String position, float salary) {
		this.position = position;
		this.salary = salary;
	}

	void transfer(String dep) {
		this.department = dep;
	}

	void teacherInfo() {
		super.showData();
		System.out.println("Position : " + getPosition());
		System.out.println("Department : " + getDepartment());
		System.out.println("Salary : " + getSalary());
	}
}// class block
