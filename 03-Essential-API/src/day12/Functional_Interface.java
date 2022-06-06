package day12;

class Myclass implements Interface1 {

	@Override
	public void display(String name) {
		System.out.println(name);

	}

}

public class Functional_Interface {
	public static void main(String[] args) {
		Interface1 test = new Myclass();
		test.display("cherry");

		Interface1 test1 = new Interface1() {

			@Override
			public void display(String name) {
				System.out.println(name);

			}
		};
		test1.display("aung");

		Interface1 test2 = (str) -> System.out.println(str);
		test2.display("Kyaw");

		Interface3 test3 = (name, password) -> {
			if (name.equals("jeon") && password.equals("123")) {
				return true;
			} else {
				return false;
			}
		};
		System.out.println(test3.checkLogin("jeon", "123") ? "login succes" : "Invalid login");
		System.out.println(test3.checkLogin("mmit", "456") ? "login succes" : "Invalid login");

		Interface2 sum = (num1, num2) -> num1 + num2;
		Interface2 mul = (num1, num2) -> num1 * num2;
		Interface2 div = (num1, num2) -> num1 / num2;
		System.out.println("sum : " + sum.operate(100, 50));
		System.out.println("mul : " + mul.operate(100, 50));
		System.out.println("div : " + div.operate(100, 50));
	}

}
