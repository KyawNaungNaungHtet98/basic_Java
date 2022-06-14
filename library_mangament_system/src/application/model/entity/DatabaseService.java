package application.model.entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import application.controller.LoginController;
import application.model.service.Author;
import application.model.service.Book;
import application.model.service.Category;
import application.model.service.Librian;
import application.model.service.Members;
import application.model.service.Transcation;

public class DatabaseService {

	// Log in
	public static Librian logIn(String email, String password) {
		Librian librian = null;
		try (Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM librian WHERE email = ? AND password = ?";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, email);
			pstm.setString(2, password);
			var rs = pstm.executeQuery();
			while (rs.next()) {
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

	// Category
	public static List<Category> viewAllCategory() {
		List<Category> list = new ArrayList<>();
		try (Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM category";
			var pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while (rs.next()) {
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
		try (Connection con = MyConnection.getConnection()) {
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
		try (Connection con = MyConnection.getConnection()) {
			String query = "DELETE FROM category WHERE id = ? ";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// librian register
	public static boolean registerLibrian(String username, String email, String pass) {
		try (Connection con = MyConnection.getConnection()) {
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

	// Member
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

	public static List<Members> viewAllMembers() {
		List<Members> list = new ArrayList<>();
		try (Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM member";
			var pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while (rs.next()) {
				Members member = new Members();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setRoll(rs.getInt("roll_no"));
				member.setYear(rs.getString("class_year"));
				member.setAcademic(rs.getString("academic_year"));
				member.setRegister_date(convertTime(rs.getString("register_date")));
				member.setExpired_date(convertTime(rs.getString("expired_date")));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Members> searchMember(String id, String member_name) {
		List<Members> list = new ArrayList<>();
		try (var con = MyConnection.getConnection()) {
			String query = "SELECT * FROM member";
			List<Object> params = new ArrayList<>();
			if ((id.isEmpty()) && (!member_name.isEmpty())) {
				query += " WHERE name LIKE ?";
				params.add("%" + member_name + "%");
			} else if ((!id.isEmpty()) && (member_name.isEmpty())) {
				query += " WHERE id LIKE ?";
				params.add("%" + id + "%");
			} else {
				query += " WHERE id LIKE ?";
				params.add("%" + id + "%");
				query += " AND name LIKE ?";
				params.add("%" + member_name + "%");
			}
			PreparedStatement pstm = con.prepareStatement(query);
			for (var i = 0; i < params.size(); i++) {
				pstm.setObject((i + 1), params.get(i));
			}
			var rs = pstm.executeQuery();
			while (rs.next()) {
				Members m = new Members();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setRoll(rs.getInt("roll_no"));
				m.setYear(rs.getString("class_year"));
				m.setAcademic(rs.getString("academic_year"));
				m.setRegister_date(convertTime(rs.getString("register_date")));
				m.setExpired_date(convertTime(rs.getString("expired_date")));

				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private static LocalDate convertTime(String string) {
		LocalDate time = LocalDate.parse(string);

		return time;
	}

	public static boolean updateMember(Members member) {
		try (Connection con = MyConnection.getConnection()) {
			String query = "UPDATE member SET roll_no = ? ,class_year = ? ,academic_year = ?,register_date = ? ,expired_date = ? WHERE name = ?";
			var pstm = con.prepareStatement(query);
			pstm.setString(6, member.getName());
			pstm.setInt(1, member.getRoll());
			pstm.setString(2, member.getYear());
			pstm.setString(3, member.getAcademic());
			pstm.setDate(4, Date.valueOf(member.getRegister_date()));
			pstm.setDate(5, Date.valueOf(member.getRegister_date().plusYears(1)));

			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public static boolean deleteMember(Members member) {
		try (Connection con = MyConnection.getConnection()) {
			String query = "DELETE FROM member WHERE id = ? ";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, member.getId());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static List<Author> findAllAuthors() {
		List<Author> list = new ArrayList<>();
		try (Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM author";
			var pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while (rs.next()) {
				Author a = new Author();
				a.setId(rs.getInt("id"));
				a.setName(rs.getString("name"));
				a.setCity(rs.getString("city"));
				a.setBirthday(convertTime(rs.getString("birthday")));
				list.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Author> searchAuthor(String name) {
		List<Author> list = new ArrayList<>();
		try (Connection con = MyConnection.getConnection()) {
			String query = "SELECT * FROM author WHERE name LIKE ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, "%" + name + "%");
			var rs = pstm.executeQuery();
			while (rs.next()) {
				var author = new Author();
				author.setBirthday(LocalDate.parse(rs.getString("birthday")));
				author.setName(rs.getString("name"));
				author.setCity(rs.getString("city"));
				author.setId(rs.getInt("id"));
				list.add(author);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public static boolean addAuthor(Author author) {
		try (var con = MyConnection.getConnection()) {
			String query = "INSERT INTO author (name,city,birthday) VALUES (?,?,?)";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, author.getName());
			pstm.setString(2, author.getCity());
			pstm.setDate(3, Date.valueOf(author.getBirthday()));
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public static void updateAuthor(Author author) {
		try (var con = MyConnection.getConnection()) {
			String query = "UPDATE author SET name = ? , city = ? , birthday = ? WHERE id = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, author.getName());
			pstm.setString(2, author.getCity());
			pstm.setDate(3, Date.valueOf(author.getBirthday()));
			pstm.setInt(4, author.getId());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void deleteAuthor(int i) {
		try (Connection con = MyConnection.getConnection()) {
			String delete = "DELETE FROM author WHERE id = ?";
			var pstm = con.prepareStatement(delete);
			pstm.setInt(1, i);
			pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static List<Book> vierAllBook() {
		List<Book> list = new ArrayList<>();
		try (Connection con = MyConnection.getConnection()) {
			String query = "SELECT b.*, a.name 'author', c.name 'category',l.username 'username' FROM book b,author a,category c,librian l\r\n"
					+ "WHERE b.author_id = a.id AND\r\n" + "b.category_id = c.id AND\r\n" + "b.created_by = l.id";
			var pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setCode(rs.getInt("code"));
				b.setTitle(rs.getString("title"));
				Librian l = new Librian();
				l.setId(rs.getInt("created_by"));
				l.setUsername(rs.getString("username"));
				b.setUser(l);
				Author auth = new Author();
				auth.setId(rs.getInt("author_id"));
				auth.setName(rs.getString("author"));

				b.setAuthor(auth);

				Category cate = new Category();
				cate.setId(rs.getInt("category_id"));
				cate.setName(rs.getString("category"));
				b.setCategory(cate);
				b.setAvailable(rs.getInt("available"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Book> searchBook(String name, String title, String category) {
		List<Book> list = new ArrayList<>();
		try (var con = MyConnection.getConnection()) {
			String query = "SELECT b.*, a.name 'author', c.name 'category',l.username 'username' FROM book b,author a,category c,librian l\r\n"
					+ "WHERE b.author_id = a.id AND\r\n" + "b.category_id = c.id AND\r\n" + "b.created_by = l.id";
			List<Object> params = new ArrayList<>();

			if (!name.isEmpty()) {
				query += " AND a.name LIKE ?";
				params.add("%" + name + "%");
			}
			if (!category.isEmpty()) {
				query += " AND c.name LIKE ?";
				params.add("%" + category + "%");
			}
			if (!title.isEmpty()) {
				query += " AND b.title LIKE ?";
				params.add("%" + title + "%");
			}
			PreparedStatement pstm = con.prepareStatement(query);
			for (var i = 0; i < params.size(); i++) {
				pstm.setObject((i + 1), params.get(i));
			}

			var rs = pstm.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setCode(rs.getInt("code"));
				b.setTitle(rs.getString("title"));
				Librian l = new Librian();
				l.setId(rs.getInt("created_by"));
				l.setUsername(rs.getString("username"));
				b.setUser(l);
				Author auth = new Author();
				auth.setId(rs.getInt("author_id"));
				auth.setName(rs.getString("author"));

				b.setAuthor(auth);

				Category cate = new Category();
				cate.setId(rs.getInt("category_id"));
				cate.setName(rs.getString("category"));
				b.setCategory(cate);
				b.setAvailable(rs.getInt("available"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean addBook(Book b) {
		boolean result = false;
		try (Connection con = MyConnection.getConnection()) {
			String insert = "INSERT INTO book(title,category_id,author_id,created_by) VALUES (?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(insert);
			pstm.setString(1, b.getTitle());
			pstm.setInt(2, b.getCategory().getId());
			pstm.setInt(3, b.getAuthor().getId());
			pstm.setInt(4, b.getUser().getId());
			pstm.executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean updateBook(Book b) {
		try (var con = MyConnection.getConnection()) {
			String query = "UPDATE book SET title = ? , author_id = ? , category_id = ? WHERE code = ?";
			var pstm = con.prepareStatement(query);
			pstm.setString(1, b.getTitle());
			pstm.setInt(2, b.getAuthor().getId());
			pstm.setInt(3, b.getCategory().getId());

			pstm.setInt(4, b.getCode());

			pstm.executeUpdate();
			return true;
		} catch (Exception e) {

		}
		return false;

	}

	public static boolean deleteBook(Book b) {
		try (var con = MyConnection.getConnection()) {
			String query = "DELETE FROM book where code = ?";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, b.getCode());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static List<Transcation> findAllborrowBook() {
		List<Transcation> list = new ArrayList<>();
		try (Connection con = MyConnection.getConnection()){
			String query = "SELECT book.title, member.name,librian.username,transaction.*  FROM transaction , book , member ,librian WHERE transaction.member_id = member.id \r\n"
					+ "AND transaction.book_id = book.code AND transaction.librian_id = librian.id";
			var pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while (rs.next()) {
				Transcation t = new Transcation();
				t.setId(rs.getInt("id"));
				Members m = new Members();
				m.setId(rs.getInt("member_id"));
				m.setName(rs.getString("name"));
				t.setMember(m);
				Book b = new Book();
				b.setCode(rs.getInt("book_id"));
				b.setTitle(rs.getString("title"));
				t.setBook(b);
				Librian l = new Librian();
				l.setId(rs.getInt("librian_id"));
				l.setUsername(rs.getString("username"));
				t.setLibrian(l);
				t.setBorrow_date(convertTime(rs.getString("borrow_date")));
				t.setDue_date(convertTime(rs.getString("due_date")));
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean borrowBook(String code, String member_id) throws SQLException {
		if(checkBook(code) == false) {
			return false;
		}
		
		if(checkMember(member_id) == false) {
			return false;
		}
		
		Connection con = MyConnection.getConnection();
		try {
			
			String query1 = "INSERT INTO transaction(member_id,book_id,borrow_date,due_date,fees,librian_id) VALUES (?,?,?,?,?,?)";
			String query2 = "UPDATE book SET available = ? WHERE code = ?";
			con.setAutoCommit(false);
			var pstm = con.prepareStatement(query1);
			pstm.setInt(1, Integer.parseInt(member_id));
			pstm.setInt(2, Integer.parseInt(code));
			pstm.setDate(3, Date.valueOf(LocalDate.now()));
			pstm.setDate(4, Date.valueOf(LocalDate.now().plusDays(7)));
			pstm.setInt(5, 0);
			pstm.setInt(6, LoginController.login_user.getId());
			pstm.executeUpdate();
			pstm = con.prepareStatement(query2);
			pstm.setInt(1, 1);
			pstm.setInt(2, Integer.parseInt(code));
			pstm.executeUpdate();
			con.commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			
		} finally {
			if (con != null) {
			con.close();
			}
		}
		return false;
		
	}

	private static boolean checkMember(String member_id) {
		List<Transcation> list = new ArrayList<>();
		try (Connection con = MyConnection.getConnection()){
			String query = "SELECT book.title, member.name,librian.username,transaction.*  FROM transaction , book , member ,librian WHERE transaction.member_id = member.id \r\n"
					+ "AND transaction.book_id = book.code AND transaction.librian_id = librian.id AND member_id = ?";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, Integer.parseInt(member_id));
			var rs =pstm.executeQuery();
			while(rs.next()) {
			Transcation t = new Transcation();
			t.setId(rs.getInt("id"));
			Members m = new Members();
			m.setId(rs.getInt("member_id"));
			m.setName(rs.getString("name"));
			t.setMember(m);
			Book b = new Book();
			b.setCode(rs.getInt("book_id"));
			b.setTitle(rs.getString("title"));
			t.setBook(b);
			Librian l = new Librian();
			l.setId(rs.getInt("librian_id"));
			l.setUsername(rs.getString("username"));
			t.setLibrian(l);
			t.setBorrow_date(convertTime(rs.getString("borrow_date")));
			t.setDue_date(convertTime(rs.getString("due_date")));
			list.add(t);
		}
		if (list.size() > 3) {
			System.out.println("chech size");
			return false;
		}
		
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

	private static boolean checkBook(String code) {
		List<Book> list = new ArrayList<>();
		try (Connection con = MyConnection.getConnection()){
			String query = "SELECT * FROM book where code = ?";
			var pstm = con.prepareStatement(query);
			pstm.setInt(1, Integer.parseInt(code));
			var rs = pstm.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setCode(rs.getInt("code"));
				b.setTitle(rs.getString("title"));
				Librian l = new Librian();
				l.setId(rs.getInt("created_by"));
				b.setUser(l);
				Author auth = new Author();
				auth.setId(rs.getInt("author_id"));

				b.setAuthor(auth);

				Category cate = new Category();
				cate.setId(rs.getInt("category_id"));
				b.setCategory(cate);
				b.setAvailable(rs.getInt("available"));
				list.add(b);
				
			}
			List<Integer> available = list.stream().map(a->a.getAvailable()).toList();
			
			if(available.contains(0)) {
					return true;
			} 
			if(available.contains(1)) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

	public static List<Transcation> findReturnBook() {
		List<Transcation> list = new ArrayList<>();
		try (Connection con = MyConnection.getConnection()){
			String query = "SELECT book.title, member.name,librian.username,transaction.*  FROM transaction , book , member ,librian WHERE transaction.member_id = member.id \r\n"
					+ "AND transaction.book_id = book.code AND transaction.librian_id = librian.id";
			var pstm = con.prepareStatement(query);
			var rs = pstm.executeQuery();
			while (rs.next()) {
				Transcation t = new Transcation();
				t.setId(rs.getInt("id"));
				Members m = new Members();
				m.setId(rs.getInt("member_id"));
				m.setName(rs.getString("name"));
				t.setMember(m);
				Book b = new Book();
				b.setCode(rs.getInt("book_id"));
				b.setTitle(rs.getString("title"));
				t.setBook(b);
				Librian l = new Librian();
				l.setId(rs.getInt("librian_id"));
				l.setUsername(rs.getString("username"));
				t.setLibrian(l);
				t.setBorrow_date(convertTime(rs.getString("borrow_date")));
				t.setDue_date(convertTime(rs.getString("due_date")));
				LocalDate date = LocalDate.now();
				LocalDate borrow = convertTime(rs.getString("due_date"));
				int num = date.compareTo(borrow);
				t.setFees(num*50);
				t.setReturn_date(LocalDate.now());
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean findReturnBook(Transcation return_book) throws SQLException {
//		if(checkReturnDate(return_book) == false) {
//			return false;
//		}
		
		Connection con = MyConnection.getConnection();
		try {
			
			String query1 = "DELETE FROM transaction WHERE id = ?";
			String query2 = "UPDATE book SET available = ? WHERE code = ?";
			con.setAutoCommit(false);
			var pstm = con.prepareStatement(query1);
			pstm.setInt(1, return_book.getId());
			pstm.executeUpdate();
			pstm = con.prepareStatement(query2);
			pstm.setInt(1, 0);
			pstm.setInt(2, return_book.getBook().getCode());
			pstm.executeUpdate();
			con.commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			
		} finally {
			if (con != null) {
			con.close();
			}
		}
		return false;
		
		
	}

//	private static boolean checkReturnDate(Transcation return_book) {
//		try (var con = MyConnection.getConnection()){
//			String query = "UPDATE transaction SET return_date = ?,fees = ? WHERE id = ? ";
//			var pstm = con.prepareStatement(query);
//			LocalDate date = LocalDate.now();
//			LocalDate borrow = return_book.getDue_date();
//			int num = date.compareTo(borrow);
//			pstm.setDate(1, Date.valueOf(LocalDate.now()));
//			pstm.setInt(2, num*500);
//			pstm.setInt(3, return_book.getId());
//			pstm.executeUpdate();
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//		
//		
//	}

	public static List<Transcation> searchReturnBook(String code, String id) {
		List<Transcation> list = new ArrayList<>();
		try (var con = MyConnection.getConnection()) {
			String query = "SELECT book.title, member.name,librian.username,transaction.*  FROM transaction , book , member ,librian WHERE transaction.member_id = member.id \r\n"
					+ "AND transaction.book_id = book.code AND transaction.librian_id = librian.id";
			List<Object> params = new ArrayList<>();

			if (!code.isEmpty()) {
				query += " AND transaction.book_id LIKE ?";
				params.add("%" + code + "%");
			}
			if (!id.isEmpty()) {
				query += " AND transaction.member_id LIKE ?";
				params.add("%" + id + "%");
			}
			PreparedStatement pstm = con.prepareStatement(query);
			for (var i = 0; i < params.size(); i++) {
				pstm.setObject((i + 1), params.get(i));
			}

			var rs = pstm.executeQuery();
			while (rs.next()) {
				Transcation t = new Transcation();
				t.setId(rs.getInt("id"));
				Members m = new Members();
				m.setId(rs.getInt("member_id"));
				m.setName(rs.getString("name"));
				t.setMember(m);
				Book b = new Book();
				b.setCode(rs.getInt("book_id"));
				b.setTitle(rs.getString("title"));
				t.setBook(b);
				Librian l = new Librian();
				l.setId(rs.getInt("librian_id"));
				l.setUsername(rs.getString("username"));
				t.setLibrian(l);
				t.setBorrow_date(convertTime(rs.getString("borrow_date")));
				t.setDue_date(convertTime(rs.getString("due_date")));
				LocalDate date = LocalDate.now();
				LocalDate borrow = convertTime(rs.getString("due_date"));
				int num = date.compareTo(borrow);
				
				t.setFees(num*50);
				t.setReturn_date(LocalDate.now());
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


}
