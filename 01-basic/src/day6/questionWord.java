package day6;

import java.util.Scanner;

public class questionWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter a one sentence : ");
			String sentence = sc.nextLine();
			String present = sentence.substring(0, 5);
			boolean situation = sentence.contains("?");
			if (situation == true) {
				System.out.println("Your sentence is question type.");
				if (present.contains("Are") || present.contains("Do") || present.contains("Does")
						|| present.contains("Is") || present.contains("Am") || present.contains("Wh")
						|| present.contains("How")) {
					System.out.println("Question is simple present tense");
				} else {
					System.out.println("Question is not simple present tense");
				}
			} else {
				if (present.contains("Are") || present.contains("Do") || present.contains("Does")
						|| present.contains("Is") || present.contains("Am") || present.contains("Wh")
						|| present.contains("How")) {
					System.out.println("Please enter '?'");
					System.out.println("U are writing question type words");
				} else {
					System.out.println("Your sentence is answer type.");
				}
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			sc.close();
		}
	}
}
