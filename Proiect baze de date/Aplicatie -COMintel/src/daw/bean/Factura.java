package daw.bean;

public class Factura {
	private int nr_factura;
	private int id_abonat;
	private String data_emitere;
	private String data_scadenta;
	private float total_plata;
	private String denumire_abonament;
	
	public Factura(int nr_factura, int id_abonat, String data_emitere, String data_scadenta, float total_plata, String denumire_abonament) {
		super();
		this.nr_factura = nr_factura;
		this.id_abonat = id_abonat;
		this.data_emitere = data_emitere;
		this.data_scadenta = data_scadenta;
		this.total_plata = total_plata;
		this.denumire_abonament = denumire_abonament;
	}
	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getNr_factura() {
		return nr_factura;
	}
	public String getDenumire_abonament() {
		return denumire_abonament;
	}
	public void setDenumire_abonament(String denumire_abonament) {
		this.denumire_abonament = denumire_abonament;
	}
	public void setNr_factura(int nr_factura) {
		this.nr_factura = nr_factura;
	}
	public int getId_abonat() {
		return id_abonat;
	}
	public void setId_abonat(int id_abonat) {
		this.id_abonat = id_abonat;
	}
	public String getData_emitere() {
		return data_emitere;
	}
	public void setData_emitere(String data_emitere) {
		this.data_emitere = data_emitere;
	}
	public String getData_scadenta() {
		return data_scadenta;
	}
	public void setData_scadenta(String data_scadenta) {
		this.data_scadenta = data_scadenta;
	}
	public float getTotal_plata() {
		return total_plata;
	}
	public void setTotal_plata(float total_plata) {
		this.total_plata = total_plata;
	}
	
}

