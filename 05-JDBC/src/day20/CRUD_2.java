package day20;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;



public class CRUD_2 {
	public static void main(String[] args) throws SQLException {
		saveMultipleEmployee();
	}

	private static void saveMultipleEmployee() throws SQLException {
		var empList = new ArrayList<Employee>();
		Scanner sc = new Scanner(System.in);
		for(var i=0; i < 2; i++) {
			System.out.println("Enter data for employee " + (i+1));
			Employee emp = new Employee();
			
			System.out.println("Enter Emp no : ");
			emp.setEmpId(Integer.parseInt(sc.nextLine()));
			System.out.println("Enter Email : ");
			emp.setEmail(sc.nextLine());
			System.out.println("Enter Password : ");
			emp.setPassword(sc.nextLine());
			System.out.println("Enter city : ");
			emp.setCity(sc.nextLine());
			System.out.println("Emter salary : ");
			emp.setSalary(Double.parseDouble(sc.nextLine()));
			System.out.println("Enter birthday : ");
			emp.setBirthday(LocalDate.parse(sc.nextLine()));
			empList.add(emp);
		}
		//DataBaseHandler.saveEmployee(empList);
		DataBaseHandler.manageTransaction(empList);
		System.out.println("success");
		
	}

//	private static void saveEmployee() {
//		// TODO Auto-generated method stub
//		
//	}
	
}
