package application.model.entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import application.model.service.Author;
import application.model.service.Book;
import application.model.service.Category;
import application.model.service.Librian;
import application.model.service.Members;

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

	private static LocalDate convertTime(String input) {
		LocalDate time = LocalDate.parse(input);

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
}
