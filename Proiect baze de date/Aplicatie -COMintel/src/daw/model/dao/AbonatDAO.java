package daw.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daw.bean.Abonament;
import daw.bean.Abonat;
import daw.util.ConnectionManager;

public class AbonatDAO {
		
	public ArrayList<Abonat> getAbonati(){
		ArrayList<Abonat> abonati = new ArrayList<Abonat>();
		
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			result = statement.executeQuery("select * from abonati");
			while(result.next()) {
				Abonat temp_abonat = new Abonat(result.getInt("ID_ABONAT"), result.getString("NUME"), result.getString("PRENUME"), result.getString("ADRESA"), result.getString("TELEFON"), result.getString("CNP") ,result.getInt("COD_ABONAMENT"));
				abonati.add(temp_abonat);
			}
			statement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return abonati;
	}
	
	public String stergereAbonat(int id) {
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			String query ="DELETE FROM ABONATI WHERE ID_ABONAT = " + id;
			result = statement.executeQuery(query);
			return "SUCCESS";
		}catch(SQLException e){
			e.printStackTrace();
			return "INVALID";
		}
	}
	
	public Abonat getAbonat(int id) {
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		Abonat abonat = new Abonat();
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			String query ="SELECT * FROM ABONATI WHERE ID_ABONAT = " + id;
			result = statement.executeQuery(query);
			result.next();
			abonat = new Abonat(result.getInt("ID_ABONAT"), result.getString("NUME"), result.getString("PRENUME"), result.getString("ADRESA"),  result.getString("TELEFON"), result.getString("CNP"), result.getInt("COD_ABONAMENT"));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return abonat;
	}
	
	public String editareAbonat(Abonat abonat) {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			String query ="UPDATE ABONATI SET NUME = '" + abonat.getNume() + "', PRENUME = '"+ abonat.getPrenume() + "', ADRESA = '" + abonat.getAdresa() + "', TELEFON = '" + abonat.getTelefon() + "', CNP = '" + abonat.getCnp() + "', COD_ABONAMENT = " + abonat.getCod_abonament() + "WHERE ID_ABONAT = " + abonat.getId_abonat();
			statement.executeUpdate(query);
			conn.close();
			return "SUCCESS";
		}catch(SQLException e){
			return "INVALID";
		}
	}
	
	public String adaugaAbonat(Abonat abonat) {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			String query ="INSERT INTO ABONATI (NUME, PRENUME, ADRESA, TELEFON, CNP, COD_ABONAMENT) VALUES('" + abonat.getNume() + "', '"+ abonat.getPrenume() + "','" + abonat.getAdresa() + "','" + abonat.getTelefon() + "','" + abonat.getCnp() + "'," + abonat.getCod_abonament()+ ")";
			statement.executeUpdate(query);
			conn.close();
			return "SUCCESS";
		}catch(SQLException e){
			e.printStackTrace();
			return "INVALID";
			
		}
	}
	
	public Abonat getLastRecord(){
		Abonat abonat = new Abonat();
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			String query ="SELECT * FROM ABONATI";
			result = statement.executeQuery(query);
			while(result.next()) {
				abonat  = new Abonat(result.getInt("ID_ABONAT"), result.getString("NUME"), result.getString("PRENUME"), result.getString("ADRESA"),  result.getString("TELEFON"), result.getString("CNP"), result.getInt("COD_ABONAMENT")); 
				System.out.println(abonat.getId_abonat());
			}
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
		return abonat;
	}
}
