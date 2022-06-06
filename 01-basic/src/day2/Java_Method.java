package day2;

public class Java_Method {
	int num1 = 10;//instance field
	static int num2 = 20;//static field
	
	public void instance_method() {
//		Both instance and static fields ( Or )  
//		Both instance and static Method can be used inside it
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
//		static_method();
	}
	public static void static_method() {
//		Instance fields and “this” and “super” keywords cannot be used inside it.
		//System.out.println("num1 = "+ num1); num1 is instance So can;t use num1
		System.out.println("num2 = " + num2);
		//instance_method(); can't use directly instance  (need to build class)
//		Java_Method instance = new Java_Method();
//		instance.instance_method();
		
	}
	public static void main(String[] args) {
		//instance method
		System.out.println("---Instance Method---");
		Java_Method obj = new Java_Method();
		obj.instance_method();
		
		//static method
		System.out.println("---Static Method---");
		static_method();
		Java_Method.static_method();
	}
}
