package daw.util;

import java.sql.*;

public class ConnectionManager {

	public static Connection createConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // link-ul aferent bazei de date
		String username = "SYSTEM"; // User-ul care administreaza baza de date
		String password = "1234"; // Parola userului care administreaza baza de date
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
				conn = DriverManager.getConnection(url, "SYSTEM", "1234");  // creearea conexiunei cu baza de date utilizand adresa bazei de date userul si parola afernte bazei de date
		}catch(Exception e){
			System.out.println(e);
		}
		
		return conn;
	}
}
