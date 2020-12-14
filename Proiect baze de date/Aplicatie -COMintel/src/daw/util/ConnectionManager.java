package daw.util;

import java.sql.*;

public class ConnectionManager {

	public static Connection createConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
				conn = DriverManager.getConnection(url, "SYSTEM", "1234");
		}catch(Exception e){
			System.out.println(e);
		}
		
		return conn;
	}
}
