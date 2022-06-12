package application.model.service;

public class Book {
	private int code;
	private String title;
	private Category category;
	private Author author;
	private int available;
	private Librian user;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Librian getUser() {
		return user;
	}
	public void setUser(Librian user) {
		this.user = user;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	
	public String getCategoryName() {
		return this.category.getName();
	}
	public String getAuthorName() {
		return this.author.getName();
	}
	public String getUserName() {
		return this.user.getUsername();
	}
}
