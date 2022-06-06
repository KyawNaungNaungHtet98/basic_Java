package day11.assignment.assg4;

public class Circle implements Shape {
	int radius;

	public Circle(int i) {
		this.radius = i;
	}

	@Override
	public double area() {
		return (Math.PI * radius * radius);
	}

	@Override
	public double volume() {
		return 0;
	}

}
