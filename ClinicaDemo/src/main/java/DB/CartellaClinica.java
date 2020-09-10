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
public class CartellaClinica {

	@Id
	private String Paziente_CodiceFiscale;
	private String Anamnesi;
	private String Prescrizioni;
	private String EsamiPrecedenti;
	private String Trattamenti;
	
	public CartellaClinica() {
		
	}

	public CartellaClinica(String paziente_CodiceFiscale, String anamnesi, String prescrizioni,
			String esamiPrecedenti, String trattamenti) {
		super();
		Paziente_CodiceFiscale = paziente_CodiceFiscale;
		
		Anamnesi = anamnesi;
		Prescrizioni = prescrizioni;
		EsamiPrecedenti = esamiPrecedenti;
		Trattamenti = trattamenti;
	}
	
	public void DownloadFromDB(String Paziente_CodiceFiscale) {
		
		CartellaClinica CC;
		
		Configuration con = new Configuration().configure().addAnnotatedClass(CartellaClinica.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        CC =  session.get(CartellaClinica.class, Paziente_CodiceFiscale);
        tx.commit();
		
        
        this.Paziente_CodiceFiscale = CC.Paziente_CodiceFiscale;
		
		this.Anamnesi = CC.Anamnesi;
		this.Prescrizioni = CC.Prescrizioni;
		this.EsamiPrecedenti = CC.EsamiPrecedenti;
		this.Trattamenti = CC.Trattamenti;
	}
	
	public void UploadToDB() {
		
		CartellaClinica CC= new CartellaClinica(this.Paziente_CodiceFiscale, this.Anamnesi, this.EsamiPrecedenti, this.Prescrizioni, this.Trattamenti);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(CartellaClinica.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(CC);
        
        tx.commit();
		
	}
	
	public ArrayList<CartellaClinica> DownloadCartelleCliniche(){
	
		
		Configuration con = new Configuration().configure().addAnnotatedClass(CartellaClinica.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();

        Criteria cr = session.createCriteria(CartellaClinica.class);
        
        
        ArrayList<CartellaClinica> CartelleCliniche = (ArrayList<CartellaClinica>) cr.list();
        
        return CartelleCliniche;
        
	}
	

	public String getPaziente_CodiceFiscale() {
		return Paziente_CodiceFiscale;
	}

	public void setPaziente_CodiceFiscale(String paziente_CodiceFiscale) {
		Paziente_CodiceFiscale = paziente_CodiceFiscale;
	}


	public String getAnamnesiClinica() {
		return Anamnesi;
	}

	public void setAnamnesiClinica(String anamnesiClinica) {
		Anamnesi = anamnesiClinica;
	}

	public String getPrescrizioni() {
		return Prescrizioni;
	}

	public void setPrescrizioni(String prescrizioni) {
		Prescrizioni = prescrizioni;
	}

	public String getEsamiPrecedenti() {
		return EsamiPrecedenti;
	}

	public void setEsamiPrecedenti(String esamiPrecedenti) {
		EsamiPrecedenti = esamiPrecedenti;
	}

	public String getTrattamenti() {
		return Trattamenti;
	}

	public void setTrattamenti(String trattamenti) {
		Trattamenti = trattamenti;
	}

	@Override
	public String toString() {
		return "CartellaClinica [Paziente_CodiceFiscale=" + Paziente_CodiceFiscale + ", AnamnesiClinica=" + Anamnesi + ", Prescrizioni=" + Prescrizioni
				+ ", EsamiPrecedenti=" + EsamiPrecedenti + ", Trattamenti=" + Trattamenti + "]";
	}

	
	

}