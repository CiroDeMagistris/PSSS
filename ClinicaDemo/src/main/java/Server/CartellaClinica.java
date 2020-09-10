package Server;

public class CartellaClinica {

	private String DatiAnagraficiPaziente;
	private String AnamnesiClinica;
	private String Prescrizioni;
	private String EsamiPrecedenti;
	private String Trattamenti;
	private Paziente Paziente_CartellaClinica;
	
	public CartellaClinica() {
		
	}

	public CartellaClinica(String datiAnagraficiPaziente, String anamnesiClinica, String prescrizioni,
			String esamiPrecedenti, String trattamenti, Paziente paziente_CartellaClinica) {
		super();
		DatiAnagraficiPaziente = datiAnagraficiPaziente;
		AnamnesiClinica = anamnesiClinica;
		Prescrizioni = prescrizioni;
		EsamiPrecedenti = esamiPrecedenti;
		Trattamenti = trattamenti;
		Paziente_CartellaClinica = paziente_CartellaClinica;
	}

	public String getDatiAnagraficiPaziente() {
		return DatiAnagraficiPaziente;
	}

	public void setDatiAnagraficiPaziente(String datiAnagraficiPaziente) {
		DatiAnagraficiPaziente = datiAnagraficiPaziente;
	}

	public String getAnamnesiClinica() {
		return AnamnesiClinica;
	}

	public void setAnamnesiClinica(String anamnesiClinica) {
		AnamnesiClinica = anamnesiClinica;
	}

	public String getPrescrizioni() {
		return Prescrizioni;
	}

	public void setPrescrizioni(String prescrizioni) {
		Prescrizioni = prescrizioni;
	}

	public String getEsamiPrecedenti() {
		return EsamiPrecedenti;
	}

	public void setEsamiPrecedenti(String esamiPrecedenti) {
		EsamiPrecedenti = esamiPrecedenti;
	}

	public String getTrattamenti() {
		return Trattamenti;
	}

	public void setTrattamenti(String trattamenti) {
		Trattamenti = trattamenti;
	}

	public Paziente getPaziente_CartellaClinica() {
		return Paziente_CartellaClinica;
	}

	public void setPaziente_CartellaClinica(Paziente paziente_CartellaClinica) {
		Paziente_CartellaClinica = paziente_CartellaClinica;
	}
	
	

}