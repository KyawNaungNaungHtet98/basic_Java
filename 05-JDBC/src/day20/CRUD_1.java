package day20;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class CRUD_1 {
	public static void main(String[] args) {
		// save_with_statement();
		// save_with_prepareStatement();
		// saveEmployee();
		// LogIn();
		// viewAll();

		// update
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter Promote salary : ");
//		double salary = Double.parseDouble(sc.nextLine());
//		if(DataBaseHandler.promoteSalary(salary)) {
//			System.out.println("Update success");
//			
//		} else {
//			System.out.println("fail");
//		}
//		sc.close();

		// delete
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter city name for delete : ");
		String city = sc.nextLine();
		DataBaseHandler.deleteBycity(city);
		System.out.println("delete success");
		sc.close();

	}

	private static void viewAll() {
		try (Connection con = MyConnection.Create_connection()) {
			String query = "SELECT * FROM employee ORDER BY email DESC";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt("empNo") + "\t");
				System.out.print(rs.getString("email") + "\t");
				System.out.print(rs.getDouble("salary") + "\t");
				System.out.print(rs.getDate("birthday") + "\n");
			}
		} catch (Exception e) {

		}

	}

	private static void saveEmployee() {
		try (Scanner sc = new Scanner(System.in)) {
			Employee emp = new Employee();
			System.out.println("Enter Data for employee : ");
			System.out.print("Employee Number : ");
			emp.setEmpId(Integer.parseInt(sc.nextLine()));
			System.out.print("Email : ");
			emp.setEmail(sc.nextLine());
			System.out.println("Password : ");
			emp.setPassword(sc.nextLine());
			System.out.println("Salary : ");
			emp.setSalary(Double.parseDouble(sc.nextLine()));
			System.out.println("City : ");
			emp.setCity(sc.nextLine());
			System.out.println("Birthday (yyyy-mm-dd) : ");
			emp.setBirthday(LocalDate.parse(sc.nextLine()));

//			save_with_Statement(emp);
//			save_with_prepareStatement(emp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void LogIn() {
		try (Scanner sc = new Scanner(System.in); Connection con = MyConnection.Create_connection()) {
			System.out.println("Enter email : ");
			String email = sc.nextLine();
			System.out.println("Enter password : ");
			String pass = sc.nextLine();
			String query = "SELECT * FROM employee WHERE email = ? AND password = ? ";
			// statement
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, email);
			pstm.setString(2, pass);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				System.out.println("log in success");
			} else {
				System.out.println("Log in fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void save_with_prepareStatement(Employee emp) {
		try (Connection con = MyConnection.Create_connection()) {
			// query
			String query = """
					INSERT INTO employee (empNo,email,password,salary,city,birthday) VALUES (?,?,?,?,?,?)
					""";
			// create prepare statement
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, emp.getEmpId());
			pstm.setString(2, emp.getEmail());
			pstm.setString(3, emp.getPassword());
			pstm.setDouble(4, emp.getSalary());
			pstm.setString(5, emp.getCity());
			pstm.setDate(6, Date.valueOf(emp.getBirthday()));

			// execute query
			int result = pstm.executeUpdate();
			System.out.println((result > 0) ? "success" : "fail");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void save_with_Statement(Employee emp) {
		try (Connection con = MyConnection.Create_connection()) {
			Statement stm = con.createStatement();
			String query = "INSERT INTO employee (empNo,email,password,salary,city,birthday) " + "VALUES ("
					+ emp.getEmpId() + ",'" + emp.getEmail() + "','" + emp.getPassword() + "','" + emp.getCity() + "',"
					+ emp.getSalary() + ",'" + emp.getBirthday() + "' )";
			int result = stm.executeUpdate(query);
			System.out.println((result > 0) ? "success" : "fail");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void save_with_statement() {
		try (Connection con = MyConnection.Create_connection()) {
			// create statement
			Statement stm = con.createStatement();
			// query
			String query = """
					INSERT INTO employee (empNo,email,password,salary,city,birthday) VALUES (1002,'may@gmail.com','may','500000','Yangon','1999-12-12')
					""";
			// execute query
			int result = stm.executeUpdate(query);
			System.out.println((result > 0) ? "success" : "fail");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void save_with_prepareStatement() {
		try (Connection con = MyConnection.Create_connection()) {
			// query
			String query = """
					INSERT INTO employee (empNo,email,password,salary,city,birthday) VALUES (?,?,?,?,?,?)
					""";
			// create prepare statement
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, 1004);
			pstm.setString(2, "Hla@gmail.com");
			pstm.setString(3, "Hla");
			pstm.setDouble(4, 400000);
			pstm.setString(5, "Mdy");
			pstm.setDate(6, Date.valueOf("1995-9-31"));

			// execute query
			int result = pstm.executeUpdate();
			System.out.println((result > 0) ? "success" : "fail");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
