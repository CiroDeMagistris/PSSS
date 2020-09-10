package Server;

import java.util.ArrayList;

public class Medico {

	private int id;
	private String Nome;
	private String Cognome;
	private String Specializzazione;
	private ArrayList<CalendarioMedico> Calendario = new ArrayList<CalendarioMedico>();
	private ArrayList<Visita> Visite = new ArrayList<Visita>();

	
	
	public Medico() {
		super();
	}
	


	public Medico(int ID ,String nome, String cognome, String specializzazione, ArrayList<CalendarioMedico> calendario,
			ArrayList<Visita> visite) {
		super();
		id = ID;
		Nome = nome;
		Cognome = cognome;
		Specializzazione = specializzazione;
		Calendario = calendario;
		Visite = visite;
	}



	public void DisponibilitaMedico() {
		// TODO - implement Medico.DisponibilitaMedico
		throw new UnsupportedOperationException();
	}



	
	


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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





	public String getSpecializzazione() {
		return Specializzazione;
	}





	public void setSpecializzazione(String specializzazione) {
		Specializzazione = specializzazione;
	}





	public ArrayList<CalendarioMedico> getCalendario() {
		return Calendario;
	}





	public void setCalendario(ArrayList<CalendarioMedico> calendario) {
		Calendario = calendario;
	}





	public ArrayList<Visita> getVisite() {
		return Visite;
	}





	public void setVisite(ArrayList<Visita> visite) {
		Visite = visite;
	}
	
	

}