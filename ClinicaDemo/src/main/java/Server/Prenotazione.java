package Server;

import java.sql.Timestamp;


public class Prenotazione {

	private Timestamp Data;
	private int id;
	private String Tipologia;
	private Paziente Paziente_Prenotazione;
	private Medico Medico_Prenotazione;
	private Ambulatorio Ambulatorio_Prenotazione;
	
	public Prenotazione() {
		super();
	}
	public Prenotazione(Timestamp data, int id, String tipologia, Paziente paziente_Prenotazione,
			Medico medico_Prenotazione, Ambulatorio ambulatorio_Prenotazione) {
		super();
		Data = data;
		this.id = id;
		Tipologia = tipologia;
		Paziente_Prenotazione = paziente_Prenotazione;
		Medico_Prenotazione = medico_Prenotazione;
		Ambulatorio_Prenotazione = ambulatorio_Prenotazione;
	}
	
	public Prenotazione(DB.Prenotazione PrenotazioneDB) {
		
		this.Data = PrenotazioneDB.getData();
		this.id = PrenotazioneDB.getId();
		this.Tipologia = PrenotazioneDB.getTipologia();
		
	}
	
	public void CaricaSuDB() {
		
		DB.Prenotazione PrenotazioneDB = new DB.Prenotazione();
		PrenotazioneDB.setData(this.Data);
		PrenotazioneDB.setId(this.id);
		PrenotazioneDB.setTipologia(this.Tipologia);
		PrenotazioneDB.setAmbulatorio_codice(this.Ambulatorio_Prenotazione.getCodice());
		PrenotazioneDB.setMedico_idMedico(this.Medico_Prenotazione.getId());
		PrenotazioneDB.setPaziente_CodiceFiscale(this.Paziente_Prenotazione.getCodiceFiscale());
		
		//PrenotazioneDB.UploadToDB();
		System.out.println(PrenotazioneDB);
	}
	
	public Timestamp getData() {
		return Data;
	}
	public void setData(Timestamp data) {
		Data = data;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipologia() {
		return Tipologia;
	}
	public void setTipologia(String tipologia) {
		Tipologia = tipologia;
	}
	public Paziente getPaziente_Prenotazione() {
		return Paziente_Prenotazione;
	}
	public void setPaziente_Prenotazione(Paziente paziente_Prenotazione) {
		Paziente_Prenotazione = paziente_Prenotazione;
	}
	public Medico getMedico_Prenotazione() {
		return Medico_Prenotazione;
	}
	public void setMedico_Prenotazione(Medico medico_Prenotazione) {
		Medico_Prenotazione = medico_Prenotazione;
	}
	public Ambulatorio getAmbulatorio_Prenotazione() {
		return Ambulatorio_Prenotazione;
	}
	public void setAmbulatorio_Prenotazione(Ambulatorio ambulatorio_Prenotazione) {
		Ambulatorio_Prenotazione = ambulatorio_Prenotazione;
	}
	@Override
	public String toString() {
		return "Prenotazione [Data=" + Data + ", id=" + id + ", Tipologia=" + Tipologia + ", Paziente_Prenotazione="
				+ Paziente_Prenotazione.getNome() + " " + Paziente_Prenotazione.getCognome() + " " + ", Medico_Prenotazione=" + Medico_Prenotazione + ", Ambulatorio_Prenotazione="
				+ Ambulatorio_Prenotazione + "]";
	}
	
	

}