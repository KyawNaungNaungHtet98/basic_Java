package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	public static Connection Create_connection() throws SQLException {
		Connection con = 
				DriverManager.getConnection("jdbc:mariadb://localhost:3306/batch_2", "root", "");
		return con;
		
	}
}
