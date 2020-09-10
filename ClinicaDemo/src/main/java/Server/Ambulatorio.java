package Server;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

import DB.Prenotazione;



public class Ambulatorio {

	private String Nome;
	private String Codice;
	private ArrayList<Medico> Medici;
	private ArrayList<Prenotazione> Prenotazioni;
	private ArrayList<Prestazione> Prestazioni;
	
	
	public Ambulatorio(String nome, String codice, ArrayList<Medico> medici, ArrayList<Prenotazione> prenotazioni,
			ArrayList<Prestazione> prestazioni) {
		super();
		Nome = nome;
		Codice = codice;
		Medici = new ArrayList<Medico>();
		Prenotazioni =new ArrayList<Prenotazione>() ;
		Prestazioni = new ArrayList<Prestazione>();
	}
	
	public Ambulatorio()
	{
		
	}

	public Server.Prenotazione RicercaPrenotazione(int CodicePrenotazione) {
		
		//Carico tutte le prenotazioni dal DB al Server
		DB.Prenotazione PrenotazioneDB = new DB.Prenotazione();
		Prenotazioni = PrenotazioneDB.DownloadPrenotazioni();
		Server.Prenotazione P = null;
		boolean trovato = false;
		int i =0;
		//Se esiste questa prenotazione, carico anche il paziente
		while(i<Prenotazioni.size() && trovato == false ) {
			if(Prenotazioni.get(i).getId() == CodicePrenotazione) {
				trovato = true;
				DB.Paziente PazienteDB = new DB.Paziente();
				//Carico il paziente attraverso il Codice Fiscale
				PazienteDB.DownloadFromDB(Prenotazioni.get(i).getPaziente_CodiceFiscale());
				//Casting da PazienteDB a Paziente
				Server.Paziente PazienteServer = new Server.Paziente(PazienteDB); 
				P = new Server.Prenotazione(Prenotazioni.get(i));
				P.setPaziente_Prenotazione(PazienteServer);
			}
			else i++;
		}
		//Restituisco Null se non trovo la prenotazione
		return P;
	}

	public void AssegnaMedico() {
		// TODO - implement Ambulatorio.AssegnaMedico
		throw new UnsupportedOperationException();
	}

	
	public void AggiungiPrenotazione(Timestamp Data, String Tipologia, Paziente paziente_Prenotazione,
			Medico medico_Prenotazione) {
		
		Random rand = new Random();
		int codice = 1 + rand.nextInt(5000);
		Server.Prenotazione PrenotazioneServer = new Server.Prenotazione(Data, codice ,Tipologia ,paziente_Prenotazione,
				medico_Prenotazione, this);
		PrenotazioneServer.CaricaSuDB();
		
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCodice() {
		return Codice;
	}

	public void setCodice(String codice) {
		Codice = codice;
	}

	public ArrayList<Medico> getMedici() {
		return Medici;
	}

	public void setMedici(ArrayList<Medico> medici) {
		Medici = medici;
	}

	public ArrayList<Prenotazione> getPrenotazioni() {
		return Prenotazioni;
	}

	public void setPrenotazioni(ArrayList<Prenotazione> prenotazioni) {
		Prenotazioni = prenotazioni;
	}

	public ArrayList<Prestazione> getPrestazioni() {
		return Prestazioni;
	}

	public void setPrestazioni(ArrayList<Prestazione> prestazioni) {
		Prestazioni = prestazioni;
	}

	
	
}