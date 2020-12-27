package daw.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import daw.bean.Abonat;
import daw.bean.Contract;
import daw.util.ConnectionManager;

public class ContractDAO {
	public String adaugaContract(int id_abonat, String data_incheiere, int cod_abonament) {
		Connection conn = null;
		Statement statement = null;
		try {
			
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			SimpleDateFormat formatt = new SimpleDateFormat("yyyy-MM-dd");
			String data = formatt.format(new Date());
			LocalDate curent_date = LocalDate.parse(data);
			LocalDate end_date = LocalDate.parse(data_incheiere);
			
			
			int valabilitate = (int)ChronoUnit.DAYS.between(curent_date, end_date);
			System.out.println(valabilitate);
			String query ="INSERT INTO CONTRACTE (ID_ABONAT, VALABILITATE, DATA_INCHEIERII, COD_ABONAMENT) VALUES(" + id_abonat + ", "+ valabilitate + ",TO_DATE('" + data_incheiere + "', 'YYYY-MM-DD'), "+ cod_abonament + ")";
			statement.executeUpdate(query);
			conn.close();
			return "SUCCESS";
		}catch(SQLException e){
			e.printStackTrace();
			return "INVALID";
			
		}
	}
	
	public void deleteContract(int id) {
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			String query ="DELETE FROM CONTRACTE WHERE ID_ABONAT = " + id;
			result = statement.executeQuery(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public Contract getContract(int id) {
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		Contract contract = new Contract();
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			String query ="SELECT * FROM CONTRACTE WHERE ID_ABONAT = " + id;
			result = statement.executeQuery(query);
			result.next();
			
			String nonFormated = result.getString("DATA_INCHEIERII");
			System.out.println(nonFormated);
			String data = nonFormated.substring(0,11);
		
			contract = new Contract(result.getInt("NR_CONTRACT") ,result.getInt("ID_ABONAT"), data, result.getInt("VALABILITATE"), result.getInt("COD_ABONAMENT"));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return contract;
	}
}
