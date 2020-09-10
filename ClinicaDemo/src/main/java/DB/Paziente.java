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
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

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

	public Paziente(String nome, String cognome, int eta, String codiceFiscale,
			int idCartellaClinica) {
		super();
		Nome = nome;
		Cognome = cognome;
		Eta = eta;
		CodiceFiscale = codiceFiscale;
		cartellaclinica_idCartellaClinica = idCartellaClinica;
	}
	
	public void DownloadFromDB(String CodiceFiscale) {
		
		Paziente P;
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Paziente.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        P =  session.get(Paziente.class, CodiceFiscale);
        tx.commit();
		
        
        this.Nome = P.Nome;
		this.Cognome = P.Cognome;
		this.Eta = P.Eta;
		this.CodiceFiscale = P.CodiceFiscale;
		this.cartellaclinica_idCartellaClinica = P.cartellaclinica_idCartellaClinica;
	}
	
	public void UploadToDB() {
		
		Paziente P= new Paziente(this.Nome, this.Cognome, this.Eta, this.CodiceFiscale , this.cartellaclinica_idCartellaClinica);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Paziente.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(P);
        
        tx.commit();
		
	}
	
	public ArrayList<Paziente> DownloadPazienti(){
	
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Paziente.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();

        Criteria cr = session.createCriteria(Paziente.class);
        
        
        ArrayList<Paziente> Pazienti = (ArrayList<Paziente>) cr.list();
        
        return Pazienti;
        
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

	public int getCartellaclinica_idCartellaClinica() {
		return cartellaclinica_idCartellaClinica;
	}

	public void setCartellaclinica_idCartellaClinica(int cartellaclinica_idCartellaClinica) {
		this.cartellaclinica_idCartellaClinica = cartellaclinica_idCartellaClinica;
	}

	@Override
	public String toString() {
		return "Paziente [Nome=" + Nome + ", Cognome=" + Cognome + ", Eta=" + Eta + ", CodiceFiscale=" + CodiceFiscale
				+ ", cartellaclinica_idCartellaClinica=" + cartellaclinica_idCartellaClinica + "]";
	}

	
	
	

}