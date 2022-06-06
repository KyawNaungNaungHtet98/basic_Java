package day9;

public class PrivateConstructor {
	public static void main(String[] args) {
		DataBaseConfig obj1 = DataBaseConfig.getInstance();
		System.out.println("db name of obj1 : " + obj1.db_name);
		DataBaseConfig obj2 = DataBaseConfig.getInstance();
		System.out.println("db name of obj2 : " + obj2.db_name);
		obj2.db_name = "banking_db";
		System.out.println("db name of obj1 : " + obj1.db_name);
	}
}
class DataBaseConfig {
	//static field to store only one object
	String db_name = "employee_db";
	private static DataBaseConfig config = null;
	//private constructor
	private DataBaseConfig() {
		
	}
	//static methods to return object
	static DataBaseConfig getInstance() {
		if(config == null) {
			config = new DataBaseConfig();
		}
		return config;
	}
}
