package DB;

import java.sql.Timestamp;
//import java.util.Date;
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
public class Prenotazione {

	private Timestamp Data;
	@Id
	private int idPrenotazione;
	private String Tipologia;
	private String paziente_CodiceFiscale;
	private int medico_idMedico;
	private String Ambulatorio_Codice;
	
	public Prenotazione() {
		super();
	}
	public Prenotazione(Timestamp data, int id, String tipologia, String paziente_CodiceFiscale, int medico_idMedico,
			String ambulatorio_codice) {
		super();
		Data = data;
		this.idPrenotazione = id;
		Tipologia = tipologia;
		this.paziente_CodiceFiscale = paziente_CodiceFiscale;
		this.medico_idMedico = medico_idMedico;
		Ambulatorio_Codice = ambulatorio_codice;
	}
	
	
	
	public void DownloadFromDB(int id) {
		
		Prenotazione P;
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Prenotazione.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        P =  session.get(Prenotazione.class, id);
        tx.commit();
		
        //System.out.println(this.Data);
        
        this.Data = P.Data;
		this.idPrenotazione = P.idPrenotazione;
		this.Tipologia = P.Tipologia;
		this.paziente_CodiceFiscale = P.paziente_CodiceFiscale;
		this.medico_idMedico = P.medico_idMedico;
		this.Ambulatorio_Codice = P.Ambulatorio_Codice;
	}
	
	public void UploadToDB() {
		
		Prenotazione P= new Prenotazione(this.Data, this.idPrenotazione, this.Tipologia, this.paziente_CodiceFiscale, this.medico_idMedico, this.Ambulatorio_Codice);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Prenotazione.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(P);
        
        tx.commit();
		
	}
	
	public ArrayList<Prenotazione> DownloadPrenotazioni(){
		
		//Prenotazioni = new ArrayList<Prenotazione>();
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Prenotazione.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();

        Criteria cr = session.createCriteria(Prenotazione.class);
        
        ArrayList<Prenotazione> Prenotazioni = (ArrayList<Prenotazione>) cr.list();
        
        return Prenotazioni;
        
	}
	
	public Timestamp getData() {
		return Data;
	}
	public void setData(Timestamp data) {
		Data = data;
	}
	public int getId() {
		return idPrenotazione;
	}
	public void setId(int id) {
		this.idPrenotazione = id;
	}
	public String getTipologia() {
		return Tipologia;
	}
	public void setTipologia(String tipologia) {
		Tipologia = tipologia;
	}
	public String getPaziente_CodiceFiscale() {
		return paziente_CodiceFiscale;
	}
	public void setPaziente_CodiceFiscale(String paziente_CodiceFiscale) {
		this.paziente_CodiceFiscale = paziente_CodiceFiscale;
	}
	public int getMedico_idMedico() {
		return medico_idMedico;
	}
	public void setMedico_idMedico(int medico_idMedico) {
		this.medico_idMedico = medico_idMedico;
	}
	public String getAmbulatorio_codice() {
		return Ambulatorio_Codice;
	}
	public void setAmbulatorio_codice(String ambulatorio_codice) {
		Ambulatorio_Codice = ambulatorio_codice;
	}
	@Override
	public String toString() {
		return "Prenotazione [Data=" + Data + ", id=" + idPrenotazione + ", Tipologia=" + Tipologia + ", paziente_CodiceFiscale="
				+ paziente_CodiceFiscale + ", medico_idMedico=" + medico_idMedico + ", Ambulatorio_codice="
				+ Ambulatorio_Codice + "]";
	}

	

}