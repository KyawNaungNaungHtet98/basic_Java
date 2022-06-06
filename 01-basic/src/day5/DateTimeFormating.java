package day5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormating {
	public static void main(String[] args) {
		//predefine constant
		DateTimeFormatter date_format = DateTimeFormatter.ISO_LOCAL_DATE;
		DateTimeFormatter time_format = DateTimeFormatter.ISO_LOCAL_TIME;
		DateTimeFormatter date_time_format = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime date_time = LocalDateTime.now();
		
		//Change Format Default 
		System.out.println("Formate of date : " + date.format(date_format));
		System.out.println("Formate of time : " + time_format.format(time));
		System.out.println("Formate of Date and Time : " + date_time.format(date_time_format));
		
		//Custom pattern
		System.out.println("---Using custom pattern---");
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("MMM dd yyyy");
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("hh-mm-ss a");
		DateTimeFormatter f3 = DateTimeFormatter.ofPattern("MMMM dd yyyy 'at' h:m:ss");
		
		
		System.out.println("Default Date format : " + date);
		System.out.println("Custom Date Format : " + f1.format(date));
		
		System.out.println("Default Time Format : " + time);
		System.out.println("Custom Time Format : " + time.format(f2));
		
		System.out.println("Default Date_time Format : " + date_time);
		System.out.println("Custom Date_Time format : " + f3.format(date_time));
		
		//localized pattern
		System.out.println("---Localized Pattern ---");
		DateTimeFormatter format1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		System.out.println("Default format : " + date);
		//System.out.println("Localized format : " + date.format(format1));
		System.out.format("Long Format : %s\n", date.format(format1));
		
		
		System.out.println("Full Format : " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		System.out.println("Medium Format : " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		System.out.println("Short Format : " + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(date));
	}
}
