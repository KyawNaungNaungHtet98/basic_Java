package day6;

public class StringBuffer_testing {
	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer("Java Programming");
		buffer.append(" Language");
		
		System.out.println("Append : " + buffer);
		
		buffer.insert(5, " is a ");
		System.out.println("Insert : " + buffer.toString());
		
		buffer.replace(0, 4, "PHP");
		System.out.println("Replace : " + buffer);
		System.out.println("index of language : " + buffer.indexOf("Language"));
		System.out.println("Substring : " + buffer.substring(4));
		System.out.println("Deleting : " + buffer.delete(0, 4));
		System.out.println("After deleting : " + buffer.length());
		System.out.println("content : " + buffer);
		
	}
}
