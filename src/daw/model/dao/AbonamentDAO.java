package daw.model.dao;


import java.sql.*;

import java.util.ArrayList;

import daw.bean.Abonament;
import daw.util.ConnectionManager;

public class AbonamentDAO {
	public ArrayList<Abonament> getAbonamente(int page){
		ArrayList<Abonament> abonamente = new ArrayList<Abonament>();
		int Start;
		if(page == 1) Start = 1;
		else Start = page*5-4;
		int Stop = page*5;
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			result = statement.executeQuery("SELECT * FROM (SELECT a.*, ROWNUM rnum from (SELECT * FROM ABONAMENTE) a WHERE ROWNUM <= " + Stop + ") WHERE rnum >= " + Start);
			while(result.next()) {
				Abonament temp_abonament = new Abonament(result.getInt("COD_ABONAMENT"), result.getString("DENUMIRE"), result.getString("TIP"), result.getFloat("TRAFIC"), result.getFloat("PRET"), result.getFloat("PRET_EXTRA_TRAFIC"));
				abonamente.add(temp_abonament);
			}
			statement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return abonamente;
	}
	
	public int numberOfAbonamente() {
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		int count = 0;
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			String query ="SELECT COUNT(*) Total FROM ABONAMENTE";
			result = statement.executeQuery(query);
			result.next();
			count = result.getInt("Total");
			return count;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public String adaugaAbonament(Abonament abonament) {
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			String query ="INSERT INTO ABONAMENTE (COD_ABONAMENT, DENUMIRE, TIP, TRAFIC, PRET, PRET_EXTRA_TRAFIC) VALUES (" + abonament.getCod_abonament() + ",'" + abonament.getDenumire() + "','" + abonament.getTip() + "'," + abonament.getTrafic() + "," + abonament.getPret()+ "," + abonament.getPret_extra_benefici()+")";
			result = statement.executeQuery(query);
			return "SUCCESS";
		}catch(SQLException e){
			e.printStackTrace();
			return "INVALID";
		}
	}
	
	public String stergereAbonament(int id) {
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			String query ="DELETE FROM ABONAMENTE WHERE COD_ABONAMENT = " + id;
			result = statement.executeQuery(query);
			return "SUCCESS";
		}catch(SQLException e){
			e.printStackTrace();
			return "INVALID";
		}
	}
	
	public Abonament getAbonament(int id) {
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		Abonament abonament = new Abonament();
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			String query ="SELECT * FROM ABONAMENTE WHERE COD_ABONAMENT = " + id;
			result = statement.executeQuery(query);
			result.next();
			abonament = new Abonament(result.getInt("COD_ABONAMENT"), result.getString("DENUMIRE"), result.getString("TIP"), result.getFloat("TRAFIC"), result.getFloat("PRET"), result.getFloat("PRET_EXTRA_TRAFIC"));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return abonament;
	}
	
	public void editareAbonament(Abonament abonament) {
		Connection conn = null;
		Statement statement = null;
		int result;
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			String query ="UPDATE ABONAMENTE SET COD_ABONAMENT = " + abonament.getCod_abonament() + ", DENUMIRE = '" + abonament.getDenumire() + "', TIP = '"+ abonament.getTip() + "', TRAFIC = " + abonament.getTrafic() + ", PRET = " + abonament.getPret() + ", PRET_EXTRA_TRAFIC = " + abonament.getPret_extra_benefici() + "WHERE COD_ABONAMENT = " + abonament.getCod_abonament();
			result = statement.executeUpdate(query);
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
