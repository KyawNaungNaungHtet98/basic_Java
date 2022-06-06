package day11.abstraction;

public abstract class DatabaseUtil {
	private String db_name = "shopdb";
	//concrete method
	public void connectDatabase() {
		System.out.println("Connecting to database " + db_name + "....");
	}
	//abstract method
	public abstract void insert();
	public abstract void update();
	public abstract boolean delete(int id);
	public abstract Object findById(int id);
	
}

