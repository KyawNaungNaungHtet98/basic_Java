package day19;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testing {
	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_2","root","")){
			System.out.println("connection success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
