package daw.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import daw.bean.Abonament;
import daw.bean.Admin;
import daw.util.ConnectionManager;

public class AdminDAO {
	public String registerUser(Admin admin) {
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			String username = admin.getUsername();
			String password = admin.getPassword();
			String query ="INSERT INTO ADMINS (USERNAME, PASSWORD) VALUES ('" + username + "', '" + password + "')";
			result = statement.executeQuery(query);
			return "SUCCESS";
		}catch(SQLException e){
			e.printStackTrace();
			return "INVALID";
		}
	}
	
}
