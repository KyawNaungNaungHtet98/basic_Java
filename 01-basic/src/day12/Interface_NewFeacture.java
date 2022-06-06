package day12;

public class Interface_NewFeacture {
	public static void main(String[] args) {
		MyClass obj = new MyClass();
		obj.method1();
		obj.method2();
		InterfaceTest.method3();
	}
}

interface InterfaceTest {
	void method1();

	default void method2() {
		System.out.println("Adding new method.It can be overriden");
	}

	static void method3() {
		System.out.println("Adding new method.It cannot be overriden");
	}

}

class MyClass implements InterfaceTest {
	@Override
	public void method1() {
		System.out.println("This is overriding method");
	}
}