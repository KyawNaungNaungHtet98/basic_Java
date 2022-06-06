package day10;

public class Method_overriding {

		public static void main(String[] args) {
			Cat cat = new Cat();
			cat.show();
			cat.sound();
		}
		
}
class Animal {
	void show() {
		System.out.println("This is show method");
	}
	void sound() {
		System.out.println("some sound");
	}
}

class Cat extends Animal {
	@Override
	void sound() { // overriding method
		System.out.println("Myaung");
	}
}