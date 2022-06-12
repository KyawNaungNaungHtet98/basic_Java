package application.model.service;

import java.time.LocalDate;

public class Members {
	private int id;
	private String name;
	private int roll;
	private String year;
	private String academic;
	private LocalDate register_date;
	private LocalDate expired_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getAcademic() {
		return academic;
	}
	public void setAcademic(String academic) {
		this.academic = academic;
	}
	public LocalDate getRegister_date() {
		return register_date;
	}
	public void setRegister_date(LocalDate date) {
		this.register_date = date;
	}
	public LocalDate getExpired_date() {
		return expired_date;
	}
	public void setExpired_date(LocalDate date) {
		this.expired_date = date;
	}
		
	}
	

