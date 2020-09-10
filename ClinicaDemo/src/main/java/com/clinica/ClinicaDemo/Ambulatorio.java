package com.clinica.ClinicaDemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ambulatorio {

	private String Nome;
	@Id
	private String Codice;
	
	
	public Ambulatorio()
	{
		
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


	
	
}