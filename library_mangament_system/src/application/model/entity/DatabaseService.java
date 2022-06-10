package application.model.entity;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import application.model.service.Category;
import application.model.service.Librian;

public class DatabaseService {

	//Log in 
	public static Librian logIn(String email, String password) {
		Librian librian = null;
		try (Connection con = MyConnection.getConnection()){
			String query = "SELECT * FROM librian WHERE email = ? AND password = ?";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, email);
			pstm.setString(2, password);
			var rs = pstm.executeQuery();
			while(rs.next()) {
				librian = new Librian();
				librian.setId(rs.getInt("id"));
				librian.setEmail(rs.getString("email"));
				librian.setPassword(rs.getString("password"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return librian;
	}

	
	//Category
	public static List<Category> viewAllCategory() {
		List<Category> list = new ArrayList<>();
		try (Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM category";
			var pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while(rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	public static void saveCategory(String category) {
		try (Connection con = MyConnection.getConnection()) {
			String query = "INSERT INTO category (name) VALUES (?)";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, category);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public static void updateCategory(Category category) {
		try (Connection con = MyConnection.getConnection()){
			String query = "UPDATE category SET name = ? WHERE id = ?";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, category.getName());
			pstm.setInt(2, category.getId());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public static void deleteCategory(int id) {
		try (Connection con = MyConnection.getConnection()){
			String query = "DELETE FROM category WHERE id = ? ";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	

	//librian register
	public static boolean registerLibrian(String username, String email, String pass) {
		try (Connection con = MyConnection.getConnection()){
			String query = "INSERT INTO librian (username,email,password) VALUES (?,?,?)";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, username);
			pstm.setString(2, email);
			pstm.setString(3, pass);
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

	//Member
	public static void registerMember(String name, String roll, String year, String academic) {
		try (Connection con = MyConnection.getConnection()) {
			LocalDate date = LocalDate.now();
			String query = "INSERT INTO member (name,roll_no,class_year,academic_year,register_date,expired_date) VALUES (?,?,?,?,?,?)";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setInt(2, Integer.parseInt(roll));
			pstm.setString(3, year);
			pstm.setString(4, academic);
			pstm.setDate(5, Date.valueOf(date));
			pstm.setDate(6, Date.valueOf(date.plusYears(1)));
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
