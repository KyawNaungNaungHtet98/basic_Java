package day11.assignment.assg3;

public abstract class Shape {
	public String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public abstract double Area();
}
