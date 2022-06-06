package day4;

import java.time.LocalDateTime;
import java.time.Month;

public class Date_Time {
	public static void main(String[] args) {
		LocalDateTime current = LocalDateTime.now();
		LocalDateTime dateTime = LocalDateTime.of(2015,Month.OCTOBER,20,04,30);
		
		System.out.println("Current Time : " + current);
		System.out.println("Previous Time(Hour) : " + current.minusHours(1));
		System.out.println("Next Time(Hour) : "+ current.plusHours(1));
		System.out.println("Current Hour : " + current.getHour());
		System.out.println("Current Minute : " + current.getMinute());
	}
}
