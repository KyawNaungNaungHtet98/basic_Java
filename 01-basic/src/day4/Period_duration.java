package day4;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Period_duration {
	public static void main(String[] args) {
		LocalDate date1 = LocalDate.parse("2019-09-25");
		LocalDate date2 = LocalDate.parse("2021-10-31");
		
		int month = Period.between(date1, date2).getMonths();
		System.out.println("Number of Month : " + month);
		
		int days = Period.between(date1, date2).getDays();
		System.out.println("Number of days : " + days);
		
		LocalTime time1 = LocalTime.parse("11:30");
		LocalTime time2 = LocalTime.parse("12:00");
		long sec = Duration.between(time1, time2).getSeconds();
		System.out.println("Number of seconds : " + sec);
	}
}
