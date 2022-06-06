package day11.assignment.assg4;

public class Cube implements Shape {
	int x;

	public Cube(int i) {
		this.x = i;
	}

	@Override
	public double area() {
		return (6 * x * x);
	}

	@Override
	public double volume() {
		return (x * x * x);
	}

}
