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
	public static void save(String name) {
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
	public static void update(Category category) {
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
	public static void delete(int id) {
		try (Connection con = MyConnection.getConnection()){
			String query = "DELETE FROM category WHERE id = ? ";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
