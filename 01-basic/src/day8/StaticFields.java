package day8;

public class StaticFields {
	public static void main(String[] args) {
		//create object and initialize
		try {
			Employee emp1 = new Employee();
			emp1.initData("Aung Aung", 500000);
			
			Employee emp2 = new Employee();
			emp2.initData("Su Su", 600000);
			Employee emp3 = new Employee();
			emp3.initData("Cherry", 300000);
			//Display
			emp1.showData();
			System.out.println("--------------------");
			emp2.showData();
			System.out.println("--------------------");
			emp3.showData();
			System.out.println("--------------------");
			emp3.changeData("Cherry", 350000);
			System.out.println("After change salary : ");
			emp3.showData();
//			Employee emp4 = new Employee();
//			emp4.initData("Naung Naung", 400000);
			emp1.viewInformation();
		} catch (AppException e) {
			System.err.println(e.getMessage());
		}
		
	}// main block
}// class block

class Employee {
	static int noOfEmployee = 3;
	static int next_id = 1;
	final int empId;
	static final float bouns = 2.5f;
	String name;
	int salary;
	
	Employee() throws AppException {
		if(next_id > noOfEmployee) {
			 throw new AppException("Sorry Limited number has been reacher");
		}
		this.empId = next_id;
		next_id ++;
	}
	void initData(String name , int salary) {
		this.name = name;
		this.salary = salary;
	}
	void changeData(String edit_name,int edit_salary) {
		if(!name.equalsIgnoreCase(edit_name)) {
			this.name = edit_name;
		}
		if(salary!=edit_salary) {
			this.salary = edit_salary;
		}
	}
	void showData() {
		System.out.println("Id : " + this.empId);
		System.out.println("Name : " + this.name);
		System.out.println("Salary : " + this.salary);
	}
	static void changeNumberOfEmployee(int num) {
		noOfEmployee = num;
		//this.name = name;
		//salary = 10000;
		//showData();
		test();
	}
	void viewInformation() {
		System.out.println("Total No of employee : " + noOfEmployee);
		System.out.println("***Current Information***");
		showData();
		System.out.println("Next Employee no :" + next_id);
	}
	static void test() {
		
	}
}// employee block

class AppException extends Exception {
	private static final long serialVersionUID = 1L;

	public AppException(String msg) {
		super(msg);
	}
}//AppException block
