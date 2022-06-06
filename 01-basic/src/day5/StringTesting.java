package day5;

import java.time.LocalDate;
import java.util.Arrays;

public class StringTesting {
	public static void main(String[] args) {
		String s1 = new String(new char[] {'Y','W','K'});
		String s2 = new String("Java Programming");
		
		System.out.println("s1 : " + s1);
		System.out.println("s2 : " + s2);
		System.out.println("Length of s1 : " + s1.length());
		
		//change case(Upper and Lower)
		String s3 = s2.toLowerCase();
		System.out.println("After change s2 :  " + s2);
		System.out.println("s3: " + s3);
		s1 = s1.toLowerCase();
		System.out.println("s1 : " + s1);
		
		
		//substring
		String subStr = s2.substring(0, 4);
		System.out.println("First substring: " + subStr);
		System.out.println("Second substring: " + s2.substring(7));
		
		//replace
		String result = s2.replace("Java", "PHP");
		System.out.println("Result : " + result);
		System.out.println("Original : " + s2);
		
		//concat
		result = s2.concat(" Language");
		System.out.println("Concat : " + result);
		
		//searching 
		System.out.println("Contain 'Java ' : " + s2.contains("Java"));
		System.out.println("Contain 'ABC' : " + s2.contains("ABC"));
		System.out.println("Start with 'ABC' : " + s2.startsWith("ABC"));
		System.out.println("End with 'ing' : " + s2.endsWith("ing"));
		
		//Location
		int index = s2.indexOf("a");
		System.out.println("Index of a : " + index);
		System.out.println("Index of a : " + s2.lastIndexOf("a"));
		System.out.println("Inde of ABC : " + s2.indexOf("ABC"));
		
		//split 
		String[] data = s2.split(" ");
		System.out.println("Splitting data : " + Arrays.toString(data));
		char[] character = s2.toCharArray();
		System.out.println("Char array : " + Arrays.toString(character));
		
		// converting string from any data type
		String rs = String.valueOf(character);
		System.out.println("rs : " + rs);
		System.out.println("String from boolean : " + String.valueOf(true));
		System.out.println("String from Int : " + String.valueOf(100));
		System.out.println("String from LocalDate : " + String.valueOf(LocalDate.now()));
	}
}
