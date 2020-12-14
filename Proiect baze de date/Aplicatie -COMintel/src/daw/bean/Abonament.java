package daw.bean;

public class Abonament {
	public Abonament() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int cod_abonament;
	private String denumire;
	private String tip;
	private float trafic;
	private float pret;
	private float pret_extra_benefici;
	
	public Abonament(int cod_abonament, String denumire, String tip, float trafic, float pret, float pret_extra_benefici) {
		super();
		this.cod_abonament = cod_abonament;
		this.denumire = denumire;
		this.tip = tip;
		this.trafic = trafic;
		this.pret = pret;
		this.pret_extra_benefici = pret_extra_benefici;
	}
	


	public int getCod_abonament() {
		return cod_abonament;
	}
	public void setCod_abonament(int cod_abonament) {
		this.cod_abonament = cod_abonament;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public float getTrafic() {
		return trafic;
	}
	public void setTrafic(float trafic) {
		this.trafic = trafic;
	}
	public float getPret() {
		return pret;
	}
	public void setPret(float pret) {
		this.pret = pret;
	}
	public float getPret_extra_benefici() {
		return pret_extra_benefici;
	}
	public void setPret_extra_benefici(float pret_extra_benefici) {
		this.pret_extra_benefici = pret_extra_benefici;
	}
}
