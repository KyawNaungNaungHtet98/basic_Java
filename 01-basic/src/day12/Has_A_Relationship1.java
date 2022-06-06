package day12;

public class Has_A_Relationship1 {
	public static void main(String[] args) {
		Author author = new Author("Mya Than Tint", "Myaing");
		Book book1 = new Book("War and Peace",6800,author);
		
		System.out.println("Book name : " + book1.name);
		System.out.println("Book price : " + book1.price);
		System.out.println("---Author Information---");
		System.out.println("Author name : " + book1.author.name);
		System.out.println("Native Town : " + book1.author.native_town);
	}
}
class Author {
	String name;
	String native_town;
	
	Author(String name, String town ) {
		this.name = name;
		this.native_town = town;
	}
}
class Book {
	String name;
	int price;
	Author author;// has a relationship
	public Book(String name,int price,Author author) {
		this.name = name;
		this.price = price;
		this.author = author;
	}
}