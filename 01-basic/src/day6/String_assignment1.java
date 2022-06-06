package day6;

public class String_assignment1 {
	public static void main(String[] args) {
		String paragraph = "NLP techniques are becoming widely popular scientific research areas as well as Information Technology industry. "
				+ "Language technology together with Information Technology can enhance the lives of people with different capabilities. "
				+ "This system implements voice command mobile phone dialer application. "
				+ "The strength of the system is that it can make phone call to the contact name written in either English scripts or Myanmar scripts.";
		System.out.println(paragraph);
		System.out.println("Number of word : " + paragraph.length());
		int num = 0;
		char[] arr = paragraph.toCharArray();
		for (var i = 0; i < 432; i++) {
			if (arr[i] == '.') {
				num++;
			}

		}
		System.out.println("Sentences is : " + num);

	}
}
