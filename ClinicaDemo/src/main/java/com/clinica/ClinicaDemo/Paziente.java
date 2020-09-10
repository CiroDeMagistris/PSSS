package com.clinica.ClinicaDemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Paziente {

	private String Nome;
	private String Cognome;
	private int Eta;
	@Id
	private String CodiceFiscale;
	private int cartellaclinica_idCartellaClinica;
	
	public Paziente() {
		super();
	}
	

	public int getCartellaclinica_idCartellaClinica() {
		return cartellaclinica_idCartellaClinica;
	}


	public void setCartellaclinica_idCartellaClinica(int cartellaclinica_idCartellaClinica) {
		this.cartellaclinica_idCartellaClinica = cartellaclinica_idCartellaClinica;
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


	@Override
	public String toString() {
		return "Paziente [Nome=" + Nome + ", Cognome=" + Cognome + ", Eta=" + Eta + ", CodiceFiscale=" + CodiceFiscale
				+ ", cartellaclinica_idCartellaClinica=" + cartellaclinica_idCartellaClinica + "]";
	}

	
	

}