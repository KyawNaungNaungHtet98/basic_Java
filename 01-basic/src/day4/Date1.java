package day4;

import java.time.LocalDate;

public class Date1 {
	public static void main(String[] args) {
		//Local date create
		LocalDate now = LocalDate.now();
		LocalDate date1 = LocalDate.of(2016, 10, 16);
		LocalDate date2 = LocalDate.parse("2016-10-16");
		
		System.out.println("Current date : " + now);
		System.out.println("Yesterday date : " + now.minusDays(1));
		System.out.println("Tomorrow date : " + now.plusDays(1));
		
		System.out.println("Current Year : " + now.getYear());
		System.out.println("Current Month : " + now.getMonth());
		System.out.println("Current Day of week : " + now.getDayOfWeek());
		System.out.println("Current Day of month : "+ now.getDayOfMonth());
		
		System.out.println(now + " is leap year? " + now.isLeapYear());
		System.out.println(date1 + " is leap year? " + now.isLeapYear());
		System.out.println(date1 + " is the same with " + date2 + " : " + date1.equals(date2));
	}
	
}
