package day8;

import java.time.LocalDate;

class Book {
	String title;
	LocalDate public_date;
	int price;
	public Book(String title, LocalDate public_date, int price) {
		super();
		this.title = title;
		this.public_date = public_date;
		this.price = price;
	}
	public Book(Book other) {// other = book1
		this.title = other.title;
		this.price = other.price;
		this.public_date = other.public_date;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", public_date=" + public_date + ", price=" + price + "]";
	}

//	@Override
//	public String toString() {
//		
//		return String.format("Name: %s,Price %d", title,price);
//	}
}
public class Copy_constructor {
	public static void main(String[] args) {
		LocalDate publish = LocalDate.of(1961, 10, 16);
		Book book1 = new Book("Detective U san shar", publish, 6000);
		System.out.println(book1);
		Book book2 = new Book(book1);
		System.out.println(book2);
	}
}
