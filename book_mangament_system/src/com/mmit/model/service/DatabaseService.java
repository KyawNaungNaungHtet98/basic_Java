package com.mmit.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.mmit.model.entity.Author;
import com.mmit.model.entity.Category;

public class DatabaseService {

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	public static List<Category> viewAll() {
		List<Category> list = new ArrayList<>();
		try (Connection con = MyConnection.getConnection()){
			String query = "SELECT * FROM category";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setCreated_at(convertTime(rs.getString("created_at")));
				category.setUpdated_at(convertTime(rs.getString("updated_at")));
				list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	private static LocalDateTime convertTime(String input) {
		input = input.substring(0,input.lastIndexOf("."));
		LocalDateTime time = LocalDateTime.parse(input,formatter);
		
		return time;
	}
	public static void saveCategory(String name) {
		try (Connection con = MyConnection.getConnection()){
			String insert = "INSERT INTO category (name,created_at,updated_at) VALUES (?,?,?)";
			PreparedStatement pstm = con.prepareStatement(insert);
			pstm.setString(1, name);
			pstm.setDate(2,Date.valueOf(LocalDate.now()));
			pstm.setDate(3,Date.valueOf(LocalDate.now()));
			pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void updateCategory(Category category) {
		try(Connection con = MyConnection.getConnection()) {
			String query = "UPDATE category SET name = ? ,updated_at = ? WHERE id = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, category.getName());
			pstm.setDate(2, Date.valueOf(LocalDate.now()));
			pstm.setInt(3, category.getId());
			
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
	public static List<Author> findAllAuthors() {
		List<Author> list = new ArrayList<>();
		try (Connection con = MyConnection.getConnection()){
			String query = "SELECT * FROM authors ORDER BY id";
			PreparedStatement pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while(rs.next()) {
				var author = new Author();
				author.setBirthday(LocalDate.parse(rs.getString("birthday")));
				author.setName(rs.getString("name"));
				author.setCity(rs.getString("city"));
				author.setId(rs.getInt("id"));
				author.setCreated_at(convertTime(rs.getString("created_at")));
				author.setUpdated_at(convertTime(rs.getString("updated_at")));
				
				list.add(author);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void saveAuthor(Author author) {
		try (Connection con = MyConnection.getConnection()){
			String query = "INSERT INTO authors(name,city,birthday) VALUES (?,?,?)";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, author.getName());
			pstm.setString(2,author.getCity());
			pstm.setDate(3, Date.valueOf(author.getBirthday()));
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void updateAuthor(Author author) {
		try (Connection con = MyConnection.getConnection()){
			String query = "UPDATE authors SET name = ? , city = ? , birthday = ? , updated_at = ? WHERE id = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, author.getName());
			pstm.setString(2, author.getCity());
			pstm.setDate(3, Date.valueOf(author.getBirthday()));
			pstm.setDate(4, Date.valueOf(LocalDate.now()));
			pstm.setInt(5, author.getId());
			pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void deleteAuthorById(int id) {
		try (Connection con = MyConnection.getConnection()){
			String delete = "DELETE FROM authors WHERE id = ?";
			var pstm = con.prepareStatement(delete);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
