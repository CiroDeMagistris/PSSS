package Clinica;

public class Prestazione {

	private String Nome;
	private String Codice;
	public Prestazione() {
		super();
	}
	public Prestazione(String nome, String codice) {
		super();
		Nome = nome;
		Codice = codice;
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