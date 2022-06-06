package day11.assignment.assg3;

public class Rectangle extends Shape {
	int length;
	int weight;

	public Rectangle(String color, int length, int weight) {
		setColor(color);
		this.length = length;
		this.weight = weight;
	}

	@Override
	public double Area() {
		return (length * weight);
	}

	public void display() {
		System.out.println("Area : " + Area());
	}
}
