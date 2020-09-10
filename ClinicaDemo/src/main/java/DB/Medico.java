package DB;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@Entity
public class Medico {

	@Id
	private int idMedico;
	private int CalendarioMedico_idCalendarioMedico;
	private String Ambulatorio_Codice;
	private String Nome;
	private String Cognome;
	private String Specializzazione;

	public Medico() {
		super();
	}


	public Medico(int idMedico, int calendarioMedico_idCalendarioMedico, String ambulatorio_Codice, String nome,
			String cognome, String specializzazione) {
		super();
		this.idMedico = idMedico;
		CalendarioMedico_idCalendarioMedico = calendarioMedico_idCalendarioMedico;
		Ambulatorio_Codice = ambulatorio_Codice;
		Nome = nome;
		Cognome = cognome;
		Specializzazione = specializzazione;
	}
	
	public void DownloadFromDB(int idMedico) {
		
		Medico M;
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Medico.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        M =  session.get(Medico.class, idMedico);
        tx.commit();
		
        
        this.idMedico = M.idMedico;
		this.CalendarioMedico_idCalendarioMedico = M.CalendarioMedico_idCalendarioMedico;
		this.Ambulatorio_Codice = M.Ambulatorio_Codice;
		this.Nome = M.Nome;
		this.Cognome = M.Cognome;
		this.Specializzazione = M.Specializzazione;
	}
	
	public void UploadToDB() {
		
		Medico M= new Medico(this.idMedico, this.CalendarioMedico_idCalendarioMedico, this.Ambulatorio_Codice, this.Cognome, this.Nome, this.Specializzazione);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Medico.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(M);
        
        tx.commit();
		
	}
	
	public ArrayList<Medico> DownloadMedici(){
		
			
		Configuration con = new Configuration().configure().addAnnotatedClass(Medico.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();

        Criteria cr = session.createCriteria(Medico.class);
        
        ArrayList<Medico> Medici = (ArrayList<Medico>) cr.list();
        
        return Medici;
        
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




	public int getIdMedico() {
		return idMedico;
	}




	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}




	public int getCalendarioMedico_idCalendarioMedico() {
		return CalendarioMedico_idCalendarioMedico;
	}




	public void setCalendarioMedico_idCalendarioMedico(int calendarioMedico_idCalendarioMedico) {
		CalendarioMedico_idCalendarioMedico = calendarioMedico_idCalendarioMedico;
	}




	public String getAmbulatorio_Codice() {
		return Ambulatorio_Codice;
	}




	public void setAmbulatorio_Codice(String ambulatorio_Codice) {
		Ambulatorio_Codice = ambulatorio_Codice;
	}


	@Override
	public String toString() {
		return "Medico [idMedico=" + idMedico + ", CalendarioMedico_idCalendarioMedico="
				+ CalendarioMedico_idCalendarioMedico + ", Ambulatorio_Codice=" + Ambulatorio_Codice + ", Nome=" + Nome
				+ ", Cognome=" + Cognome + ", Specializzazione=" + Specializzazione + "]";
	}





	
	
	

}