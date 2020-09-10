package Server;

import java.util.ArrayList;

public class Clinica {

	private String Nome;
	private ArrayList<Ambulatorio> Ambulatori = new ArrayList<Ambulatorio>();
	private ArrayList<Paziente> Pazienti = new ArrayList<Paziente>();

	
	
	public Clinica() {
		super();
	}
	
	


	public Clinica(String nome, ArrayList<Ambulatorio> ambulatori, ArrayList<Paziente> pazienti) {
		super();
		Nome = nome;
		Ambulatori = ambulatori;
		Pazienti = pazienti;
	}
	
	




	public void RicercaPaziente(int CodiceFiscale) {
		// TODO - implement Clinica.RicercaPaziente
		throw new UnsupportedOperationException();
	}

	
	public void AssegnaAmbulatorio(int Tipologia) {
		// TODO - implement Clinica.AssegnaAmbulatorio
		throw new UnsupportedOperationException();
	}




	public String getNome() {
		return Nome;
	}




	public void setNome(String nome) {
		Nome = nome;
	}




	public ArrayList<Ambulatorio> getAmbulatori() {
		return Ambulatori;
	}




	public void setAmbulatori(ArrayList<Ambulatorio> ambulatori) {
		Ambulatori = ambulatori;
	}




	public ArrayList<Paziente> getPazienti() {
		return Pazienti;
	}




	public void setPazienti(ArrayList<Paziente> pazienti) {
		Pazienti = pazienti;
	}

	
}