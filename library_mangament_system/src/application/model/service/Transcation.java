package application.model.service;

import java.time.LocalDate;

public class Transcation {
	private int id;
	private Members member;
	private Book book;
	private LocalDate borrow_date;
	private LocalDate due_date;
	private LocalDate return_date;
	private int fees;
	private Librian librian;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Members getMember() {
		return member;
	}
	public void setMember(Members member) {
		this.member = member;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public LocalDate getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(LocalDate borrow_date) {
		this.borrow_date = borrow_date;
	}
	public LocalDate getDue_date() {
		return due_date;
	}
	public void setDue_date(LocalDate due_date) {
		this.due_date = due_date;
	}
	public LocalDate getReturn_date() {
		return return_date;
	}
	public void setReturn_date(LocalDate return_date) {
		this.return_date = return_date;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public Librian getLibrian() {
		return librian;
	}
	public void setLibrian(Librian librian) {
		this.librian = librian;
	}
	
	public String getMember_name() {
		return this.member.getName();
	}
	public String getBook_title() {
		return this.book.getTitle();
	}
	public String getLibrian_name() {
		return this.librian.getUsername();
	}
}
