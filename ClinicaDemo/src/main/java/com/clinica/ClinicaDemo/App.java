package com.clinica.ClinicaDemo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class App 
{
    public static void main( String[] args )
    {
  
        Paziente P = new Paziente();
       
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Paziente.class);
        
        //ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        //session.save(P);
        P = (Paziente) session.get(Paziente.class, "CLBCTP");
        tx.commit();
        
        System.out.println(P);
    }
}
