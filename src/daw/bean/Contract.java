package daw.bean;

public class Contract {
	private int nr_contract;
	private int id_abonat;
	private String data_incheierii;
	private int valabilitate;
	private int cod_abonament;
	public int getCod_abonament() {
		return cod_abonament;
	}
	public void setCod_abonament(int cod_abonament) {
		this.cod_abonament = cod_abonament;
	}
	public Contract(int nr_contract, int id_abonat, String data_incheierii, int valabilitate, int cod_abonament) {
		super();
		this.nr_contract = nr_contract;
		this.id_abonat = id_abonat;
		this.data_incheierii = data_incheierii;
		this.valabilitate = valabilitate;
		this.cod_abonament = cod_abonament;
	}
	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNr_contract() {
		return nr_contract;
	}
	public void setNr_contract(int nr_contract) {
		this.nr_contract = nr_contract;
	}
	public int getId_abonat() {
		return id_abonat;
	}
	public void setId_abonat(int id_abonat) {
		this.id_abonat = id_abonat;
	}
	public String getData_incheierii() {
		return data_incheierii;
	}
	public void setData_incheierii(String data_incheierii) {
		this.data_incheierii = data_incheierii;
	}
	public int getValabilitate() {
		return valabilitate;
	}
	public void setValabilitate(int valabilitate) {
		this.valabilitate = valabilitate;
	}
	
	
}
