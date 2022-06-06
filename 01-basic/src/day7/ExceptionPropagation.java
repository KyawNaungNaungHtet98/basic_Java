package day7;

public class ExceptionPropagation {
	public static void main(String[] args) {
		test();
	}

	private static void test() {
		test2();
		
	}

	private static void test2() {
		test1();
		
	}

	private static void test1() {
		System.out.println(100/0);
		
	}
	
}
