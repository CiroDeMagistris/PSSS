package Server;

public class Paziente {

	private String Nome;
	private String Cognome;
	private int Eta;
	private String CodiceFiscale;
	private CartellaClinica CartellaClinica_Paziente;
	private Prenotazione Prenotazione_Paziente;
	
	public Paziente() {
		super();
	}

	public Paziente(String nome, String cognome, int eta, String codiceFiscale,
			CartellaClinica cartellaClinica_Paziente, Prenotazione prenotazione_Paziente) {
		super();
		Nome = nome;
		Cognome = cognome;
		Eta = eta;
		CodiceFiscale = codiceFiscale;
		CartellaClinica_Paziente = cartellaClinica_Paziente;
		Prenotazione_Paziente = prenotazione_Paziente;
	}
	
	public Paziente(DB.Paziente PazienteDB) {
		this.Nome = PazienteDB.getNome();
		this.Cognome = PazienteDB.getCognome();
		this.Eta = PazienteDB.getEta();
		this.CodiceFiscale = PazienteDB.getCodiceFiscale();
		this.CartellaClinica_Paziente = null;
		this.Prenotazione_Paziente = null;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public int getEta() {
		return Eta;
	}

	public void setEta(int eta) {
		Eta = eta;
	}

	public String getCodiceFiscale() {
		return CodiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		CodiceFiscale = codiceFiscale;
	}

	public CartellaClinica getCartellaClinica_Paziente() {
		return CartellaClinica_Paziente;
	}

	public void setCartellaClinica_Paziente(CartellaClinica cartellaClinica_Paziente) {
		CartellaClinica_Paziente = cartellaClinica_Paziente;
	}

	public Prenotazione getPrenotazione_Paziente() {
		return Prenotazione_Paziente;
	}

	public void setPrenotazione_Paziente(Prenotazione prenotazione_Paziente) {
		Prenotazione_Paziente = prenotazione_Paziente;
	}

	@Override
	public String toString() {
		return "Paziente [Nome=" + Nome + ", Cognome=" + Cognome + ", Eta=" + Eta + ", CodiceFiscale=" + CodiceFiscale
				+ ", CartellaClinica_Paziente=" + CartellaClinica_Paziente + ", Prenotazione_Paziente="
				+ Prenotazione_Paziente + "]";
	}
	
	

}