package day2;

public class Type_Testing {
	public static void main(String[] args) {
		// implicit casting
		System.out.println("---implicit casting---");
		int a = 200;
		long b = a;
		double c = b;
		
		System.out.println("Int a " + a);
		System.out.println("long b " + b);
		System.out.println("double c " + c);
		
		//explicit casting
		System.out.println("---explicit casting--- ");
		double d = 57.17;
		int i = (int) d;
		
		System.out.println("double d " + d);
		System.out.println("int i "+ i);
	}
}
