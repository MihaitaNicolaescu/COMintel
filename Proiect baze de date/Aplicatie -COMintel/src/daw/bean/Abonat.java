package daw.bean;

public class Abonat {
	private int id_abonat;
	private String nume;
	private String prenume;
	private String adresa;
	private String telefon;
	private String cnp;
	private int cod_abonament;
	
	public Abonat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Abonat(int id_abonat, String nume, String prenume, String adresa, String telefon, String cnp, int cod_abonament) {
		super();
		this.id_abonat = id_abonat;
		this.nume = nume;
		this.prenume = prenume;
		this.adresa = adresa;
		this.telefon = telefon;
		this.cnp = cnp;
		this.cod_abonament = cod_abonament;
	}
	public int getId_abonat() {
		return id_abonat;
	}
	public void setId_abonat(int id_abonat) {
		this.id_abonat = id_abonat;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getCnp() {
		return cnp;
	}
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	public int getCod_abonament() {
		return cod_abonament;
	}
	public void setCod_abonament(int cod_abonament) {
		this.cod_abonament = cod_abonament;
	}
	
	
	
}
