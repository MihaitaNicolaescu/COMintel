package daw.model.dao;

import java.sql.*;

import daw.bean.Admin;
import daw.util.ConnectionManager;

public class LoginDAO {
	public String loginUser(Admin user) {
		String username = user.getUsername();
		String password = user.getPassword();
		
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			result = statement.executeQuery("SELECT USERNAME, PASSWORD FROM ADMINS WHERE USERNAME = '" +username +"' AND PASSWORD = '" + password+"'");
			if(result.next() == true) {
				return "SUCCESS";
			}
			statement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return "INVALID";
	
	}
}
