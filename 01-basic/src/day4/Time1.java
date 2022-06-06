package day4;

import java.time.LocalTime;

public class Time1 {
	public static void main(String[] args) {
		LocalTime currentTime = LocalTime.now();
		LocalTime time1 = LocalTime.of(11, 3, 45);
		LocalTime time2 = LocalTime.parse("04:30");
		
		System.out.println("Current Time : " + currentTime);
		System.out.println("Previous Time(Hour) : " + currentTime.minusHours(1));
		System.out.println("Next Time(Hour) : "+ currentTime.plusHours(1));
		System.out.println("Current Hour : " + currentTime.getHour());
		System.out.println("Current Minute : " + currentTime.getMinute());
		
		
		
	}
}
