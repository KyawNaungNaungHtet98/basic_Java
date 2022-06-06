package day11.assignment.assg4;

public class PolymorphismTest {
	public static void main(String[] args) {
		Shape[] array = new Shape[2];
		array[0] = new Cube(100);
		array[1] = new Circle(11);

		System.out.println("Cube of area " + array[0].area());
		System.out.println("Cube of volume " + array[0].volume());

		System.out.println("Circle of area " + array[1].area());
		System.out.println("Circle of volume " + array[1].volume());

	}
}
