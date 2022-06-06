package day5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DayTime_assignment1 {
	public static void main(String[] args) {
		String[] weekdays = { "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" };
		String[] weekend = { "SUNDAY", "SATURDAY" };
		LocalDate date = LocalDate.now();
		String name = date.getDayOfWeek().toString();
		DateTimeFormatter date_format = DateTimeFormatter.ofPattern("E");
		String date_change = date.format(date_format).toString();

		if (name.equals("SUNDAY") || name.equals("SATURDAY")) {
			for (var r = 0; r < 2; r++) {
				System.out.println(weekend[r]);
				if (name.equals(weekend[r])) {
					System.out.format("%s , %s", date_change, date);
					System.out.println("\n***********************");
					System.out.println("It is my holiday.");
					break;
				}
			}
		} else {
			for (var r = 0; r < 5; r++) {
				if (name.equals(weekdays[r])) {
					System.out.format("%s , %s", date_change, date);
					System.out.println("\n***********************");
					System.out.println("I have no time. I am studying Programming Language.");
					break;
				}
			}
		}
	}
}