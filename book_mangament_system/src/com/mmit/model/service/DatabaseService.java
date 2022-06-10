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
import com.mmit.model.entity.Book;
import com.mmit.model.entity.Category;
import com.mmit.model.entity.User;

public class DatabaseService {

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	public static List<Category> findAllCategory() {
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
	public static boolean saveBook(Book book) {
		boolean result = false;
		try (Connection con = MyConnection.getConnection()){
			String insert = "INSERT INTO books(code,title,price,publish_date,category_id,author_id,created_by) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(insert);
			pstm.setInt(1, book.getCode());
			pstm.setString(2, book.getTitle());
			pstm.setInt(3, book.getPrice());
			pstm.setDate(4, Date.valueOf(book.getPublish_date()));
			pstm.setInt(5, book.getCategory().getId());
			pstm.setInt(6, book.getAuthor().getId());
			pstm.setInt(7, book.getCreated_by().getId());
			pstm.executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static User Login(String email, String pass) {
		User user = null;
		try (Connection con = MyConnection.getConnection()) {
			var query = "SELECT * FROM users WHERE email = ? AND password = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, email);
			pstm.setString(2, pass);
			var rs = pstm.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setId(rs.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public static List<Book> searchBook(String author, String category, LocalDate pub_date) {
		List<Book> list = new ArrayList<>();
		try(Connection con = MyConnection.getConnection()) {
			String query = "SELECT b.code,b.title,b.price,b.publish_date,a.name 'author',c.name 'category',u.username FROM books b,authors a,category c,users u\r\n"
					+ "WHERE b.author_id = a.id AND\r\n"
					+ "b.category_id = c.id AND\r\n"
					+ "b.created_by = u.id";
			List<Object> params = new ArrayList<>();
			
			if(!author.isEmpty()) {
				query += " AND a.name LIKE ?";
				params.add("%" + author + "%");
			}
			if(!category.isEmpty()) {
				query += " AND c.name LIKE ?";
				params.add("%" + category + "%");
			}
			if(pub_date != null) {
				query += " AND b.publish_date = ? ";
				params.add(pub_date);
			}
			PreparedStatement pstm = con.prepareStatement(query);
			for(var i = 0 ; i < params.size() ; i++) {
				pstm.setObject((i+1), params.get(i));
			}
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setCode(rs.getInt("code"));
				b.setTitle(rs.getString("title"));
				b.setPrice(rs.getInt("price"));
				b.setPublish_date(LocalDate.parse(rs.getString("publish_date")));
				Author auth = new Author();
				auth.setName(rs.getString("author"));
				b.setAuthor(auth);
				
				Category cate = new Category();
				cate.setName(rs.getString("category"));
				
				b.setCategory(cate);
				
				User user = new User();
				user.setName(rs.getString("username"));
				
				b.setCreated_by(user);
				
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static Book findBookByCode(String code) {
		Book book = null;
		try (Connection con = MyConnection.getConnection()){
			String query = "SELECT b.*, a.name 'author', c.name 'category' FROM books b,authors a,category c,users u\r\n"
					+ "WHERE b.author_id = a.id AND\r\n"
					+ "b.category_id = c.id AND\r\n"
					+ "b.created_by = u.id AND  b.code = ?";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, Integer.parseInt(code));
			var rs = pstm.executeQuery();
			if(rs.next()) {
				book = new Book();
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getInt("price"));
				book.setPublish_date(LocalDate.parse(rs.getString("publish_date")));
				Author auth = new Author();
				auth.setId(rs.getInt("author_id"));
				auth.setName(rs.getString("author"));
				
				book.setAuthor(auth);
				
				Category cate = new Category();
				cate.setId(rs.getInt("category_id"));
				cate.setName(rs.getString("category"));
				
				book.setCategory(cate);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return book;
	}
	public static boolean updateBook(Book book) {
		try (var con = MyConnection.getConnection()){
			String query = "UPDATE books SET title = ? , price = ? , author_id = ? , category_id = ? , publish_date = ? WHERE code = ?";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, book.getTitle());
			pstm.setInt(2, book.getPrice());
			pstm.setInt(3, book.getAuthor().getId());
			pstm.setInt(4, book.getCategory().getId());
			pstm.setDate(5, Date.valueOf(book.getPublish_date()));
			pstm.setInt(6, book.getCode());
			
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
		
		}
		return false;
	}

}
