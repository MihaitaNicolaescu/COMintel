package daw.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import daw.bean.Abonat;
import daw.bean.Factura;
import daw.util.ConnectionManager;

public class FacturaDAO {
	
	public String adaugaFactura(int id_abonat, String data_emitere, float total_plata, String denumire_abonament) throws ParseException {
		Connection conn = null;
		Statement statement = null;
		try {
			
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			SimpleDateFormat formatt = new SimpleDateFormat("yyyy-MM-dd");
			String data = formatt.format(new Date());
			LocalDate curent_date = LocalDate.parse(data);
			LocalDate end_date = LocalDate.parse(data_emitere);
			Calendar c = Calendar.getInstance();
			c.setTime(formatt.parse(data));
			c.add(Calendar.DATE, 15);
			String data_scadenta = formatt.format(c.getTime());
			
			
			String query ="INSERT INTO FACTURI (ID_ABONAT, DATA_EMITERII, DATA_SCADENTA, TOTAL_PLATA, ABONAMENT) VALUES(" + id_abonat + ", TO_DATE('" + data_emitere + "', 'YYYY-MM-DD') ,TO_DATE('" + data_scadenta + "', 'YYYY-MM-DD'), "+ total_plata+ ", '"+denumire_abonament+"')";
			statement.executeUpdate(query);
			conn.close();
			return "SUCCESS";
		}catch(SQLException e){
			e.printStackTrace();
			return "INVALID";
			
		}
	}
	
	public ArrayList<Factura> getFacturi(int id_abonat){
		ArrayList<Factura> facturi = new ArrayList<Factura>();
		
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			result = statement.executeQuery("select * from facturi where ID_ABONAT = " + id_abonat);
			while(result.next()) {
				String data_emitere = result.getString("DATA_EMITERII");
				data_emitere = data_emitere.substring(0,11);
				String data_scadenta = result.getString("DATA_SCADENTA");
				data_scadenta = data_scadenta.substring(0,11);
				Factura temp_factura = new Factura(result.getInt("NR_FACTURA"), result.getInt("ID_ABONAT"), data_emitere, data_scadenta, result.getFloat("TOTAL_PLATA"), result.getString("ABONAMENT"));
				facturi.add(temp_factura);
			}
			statement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return facturi;
	}
	
	public String stergereFactura(int id_factura) {
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			conn = ConnectionManager.createConnection();
			statement = conn.createStatement();
			String query ="DELETE FROM FACTURI WHERE NR_FACTURA = " + id_factura;
			result = statement.executeQuery(query);
			return "SUCCESS";
		}catch(SQLException e){
			e.printStackTrace();
			return "INVALID";
		}
	}
	
	
}
