package assignment.assig3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Assignment {
	// static String[] category = { "CateA", "CateB", "CateC", "CateD" };
	static List<String> categoryList = new ArrayList<>();

	static Author authorA = new Author("authorA", "CountryA");
	static Author authorB = new Author("authorB", "CountryB");
	static Author authorC = new Author("authorC", "CountryC");
	static List<Author> authorList = new ArrayList<Author>();

	static Book book_1 = new Book(1001, "titleA", LocalDate.of(1998, 12, 2), "CateA", authorA);
	static Book book_2 = new Book(1002, "titleB", LocalDate.of(1999, 12, 2), "CateB", authorB);
	static Book book_3 = new Book(1003, "titleC", LocalDate.of(2000, 12, 2), "CateC", authorC);
	static List<Book> bookList = new ArrayList<Book>();

	public static void main(String[] args) {

		categoryList.add("CateA");
		categoryList.add("CateB");
		categoryList.add("CateC");
		categoryList.add("CateD");
		authorList.add(authorA);
		authorList.add(authorB);
		authorList.add(authorC);
		bookList.add(book_1);
		bookList.add(book_2);
		bookList.add(book_3);

		service();

	}// main block

	private static void service() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Which serive do u want to do ?");
			System.out.println("1.View all book");
			System.out.println("2.View all author");
			System.out.println("3.View all book Category");
			System.out.println("4.View Book List with author name");
			System.out.println("5.View Book List with category");
			System.out.println("6.Add new Book");
			System.out.print("Enter number (1 To 6) : ");
			int num = Integer.parseInt(sc.nextLine());
			if (num == 1) {
				viewBook();
			} else if (num == 2) {
				authorInfo();
			} else if (num == 3) {
				bookCategory();
			} else if (num == 4) {
				viewBookWithAuthor();
			} else if (num == 5) {
				viewBookWithCate();
			} else if (num == 6) {
				addNewBook();
			} else {
				System.out.println("Please retry ");
				service();
			}
			System.out.println("Do u wanna do for other service");
			System.out.println("Yes or No ?");
			System.out.println("If u want , Please Enter 'Y'");
			System.out.print("If not , Please Enter 'N'");
			String serve = sc.nextLine();
			if (serve.equalsIgnoreCase("y")) {
				service();
			} else {
				System.out.println("out of sYstem");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	private static void addNewBook() {
		try (Scanner sc = new Scanner(System.in)) {
			// Code
			System.out.print("Enter Book Code : ");
			int code = Integer.parseInt(sc.nextLine());
			for (var c : bookList) {
				if (c.getCode() == code) {
					System.out.println(c.getCode() + "is existed");
					viewBook();
					System.out.println("Please Enter new Code : ");
					code = Integer.parseInt(sc.nextLine());
				}
			}
//			// Title
			System.out.print("Enter Book Title : ");
			String title = sc.nextLine();
//
//			// Date
			System.out.println("Enter for Date : ");
			System.out.print("Enter year (yyyy): ");
			int year = Integer.parseInt(sc.nextLine());
			System.out.print("Enter month (mm): ");
			int mm = Integer.parseInt(sc.nextLine());
			System.out.print("Enter day (dd): ");
			int dd = Integer.parseInt(sc.nextLine());
			LocalDate date = LocalDate.of(year, mm, dd);

			// Category
			System.out.print("Enter Category : ");
			String cate = sc.nextLine();
			for (var c : categoryList) {
				if (!c.equalsIgnoreCase(cate)) {
					categoryList.add(cate);
					break;
				}
			}

			System.out.print("Enter author name : ");
			String author = sc.nextLine();
			boolean situation = true;
			for (var c : authorList) {
				if (c.getName().equals(author)) {
					bookList.add(new Book(code, title, date, cate, c));
					System.out.println("New Book List : ");
					System.out.format("Code : %s \nTitle : %s \nDate : %s \nCategory : %s \nAuthor name : %s ", code,
							title, date, cate, c);
					situation = false;
					break;
				}
			}
			if (situation == true) {
				System.out.println("This is new author");
				System.out.println("Please enter His country : ");
				String country = sc.nextLine();
				Author author4 = new Author(author, country);
				authorList.add(author4);
				bookList.add(new Book(code, title, date, cate, new Author(author, country)));
				System.out.println("New Book List : ");
				System.out.format("Code : %s \nTitle : %s \nDate : %s \nCategory : %s \nAuthor name : %s ", code, title,
						date, cate, author4);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void viewBookWithCate() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter for Category name : ");
			String category = sc.nextLine();
			boolean situation = true;
			for (var a : bookList) {
				if (a.getCategory().equalsIgnoreCase(category)) {
					System.out.println(a);
					situation = false;
					break;
				}
			}
			if (situation) {
				System.out.println("The book which that category is not existed ");
				// bookList.stream().filter(s->
				// s.getAuthor().getName().equalsIgnoreCase(category)).forEach(s->
				// System.out.println(s));
			}
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}

	}

	private static void viewBookWithAuthor() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter for author name : ");
			String name = sc.nextLine();
			boolean situation = true;
			for (var a : authorList) {
				if (a.getName().equalsIgnoreCase(name)) {
					System.out.println(a);
					situation = false;
					break;
				}
			}
			if (situation == false) {
				bookList.stream().filter(s -> s.getAuthor().getName().equalsIgnoreCase(name))
						.forEach(s -> System.out.println(s));
			} else {
				System.out.println("Author is not existed ");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	private static void bookCategory() {
		System.out.println("---Category Information---");
		categoryList.stream().forEach(s -> System.out.println(s));

	}

	private static void authorInfo() {
		System.out.println("---Author Infomation---");
		authorList.stream().forEach(s -> System.out.println(s));

	}

	private static void viewBook() {
		System.out.println("---Book Information---");
		bookList.stream().forEach(s -> System.out.println(s));

	}
}// assignment block
