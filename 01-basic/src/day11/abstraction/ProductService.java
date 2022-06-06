package day11.abstraction;

public class ProductService extends DatabaseUtil {

	@Override
	public void insert() {
		System.out.println("insert into product");
		
	}

	@Override
	public void update() {
		System.out.println("Product update table");
		
	}

	@Override
	public boolean delete(int id) {
		System.out.println("delete from proudct where id = " + id);
		return false;
	}

	@Override
	public Object findById(int id) {
		System.out.println("select * from product where id = " + id);
		return null;
	}
	
}
