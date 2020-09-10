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
public class Ambulatorio {

	
	private String Nome;
	@Id
	private String Codice;

	
	
	public Ambulatorio(String nome, String codice) {
		super();
		Nome = nome;
		Codice = codice;
	}
	
	public Ambulatorio()
	{
		
	}
	
	
	public void DownloadFromDB(String Codice) {
		
		Ambulatorio A;
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Ambulatorio.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        //session.save(P);
        A =  session.get(Ambulatorio.class, Codice);
        tx.commit();
		//System.out.println(A.getNome());
        
        this.Nome = A.Nome;
        this.Codice = A.Codice;
	}
	
	public void UploadToDB() {
		
		Ambulatorio A= new Ambulatorio(this.Nome, this.Codice);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Ambulatorio.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(A);
        //A =  session.get(Ambulatorio.class, Codice);
        tx.commit();
		//System.out.println(A.getNome());
	}
	
	public ArrayList<Ambulatorio> DownloadAmbulatori(){
	
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Ambulatorio.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();

        Criteria cr = session.createCriteria(Ambulatorio.class);
        
        
        ArrayList<Ambulatorio> Ambulatori = (ArrayList<Ambulatorio>) cr.list();
        
        return Ambulatori;
        
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

	@Override
	public String toString() {
		return "AmbulatorioDB [Nome=" + Nome + ", Codice=" + Codice + "]";
	}

	

	
	
}