package day11.abstraction;

public class AbstractionDemo {
	public static void main(String[] args) {
		ProductService ps = new ProductService();
		ps.connectDatabase();
		ps.insert();
		ps.update();
		ps.delete(101);
		ps.findById(102);
		System.out.println();
		System.out.println("---Abstraction object with child class ---");
		DatabaseUtil db_obj = new ProductService();
		db_obj.connectDatabase();
		db_obj.insert();
		db_obj.update();
		db_obj.delete(112);
		db_obj.findById(110);
	}
}
