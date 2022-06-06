package day6;

public class Try_catch_finally {
	public static void main(String[] args) {
		try {
			String name = null;
			System.out.println("len: " + name.length());
		} catch (Exception e) {
			System.err.print("It does not allocate");
		} finally {
			System.out.println("always exceted");
		}
		System.out.println("Outside try-finally block");

	}
}
