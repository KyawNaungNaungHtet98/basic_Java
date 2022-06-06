package day11.abstraction;

public class Bird implements Fly {
	@Override
	public void fly() {
		System.out.println("Bird flying");
	}
}
