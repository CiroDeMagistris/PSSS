package DB;

import java.util.ArrayList;
import java.util.Date;

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
public class CalendarioMedico {

	private Date Data;
	@Id
	private int idCalendarioMedico;
	
	public CalendarioMedico() {
		
	}
	
	
	public CalendarioMedico(Date data, int idCalendarioMedico) {
		super();
		Data = data;
		this.idCalendarioMedico = idCalendarioMedico;
	}



	public void DownloadFromDB(int id) {
		
		CalendarioMedico CD;
		
		Configuration con = new Configuration().configure().addAnnotatedClass(CalendarioMedico.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        CD =  session.get(CalendarioMedico.class, id);
        tx.commit();
		
        
        this.Data = CD.Data;
        this.idCalendarioMedico = CD.idCalendarioMedico;
	}
	
	public void UploadToDB() {
		
		CalendarioMedico CM= new CalendarioMedico(this.Data, this.idCalendarioMedico);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(CalendarioMedico.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(CM);
        
        tx.commit();
		
	}
	
	public ArrayList<CalendarioMedico> DownloadCalendari(int idCalendarioMedico){
	
		
		Configuration con = new Configuration().configure().addAnnotatedClass(CalendarioMedico.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction(); 

        Criteria cr = session.createCriteria(CalendarioMedico.class);
        cr.add(Restrictions.eq("idCalendarioMedico", idCalendarioMedico));
        
        ArrayList<CalendarioMedico> Calendari = (ArrayList<CalendarioMedico>) cr.list();
        
        return Calendari;
        
	}
	
	public CalendarioMedico(Date data) {
		super();
		Data = data;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}


	@Override
	public String toString() {
		return "CalendarioMedico [Data=" + Data + ", idCalendarioMedico=" + idCalendarioMedico + "]";
	}
	
	

	
	
}