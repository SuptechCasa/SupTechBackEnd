package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Etudiant;

public class EtudiantDao {
public List<Etudiant> getAllEtudiants(){
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	List<Etudiant> etudiants= session.createQuery("from Etudiant", Etudiant.class).list();
	sessionFactory.close();
	return etudiants;
}

public Etudiant addEtudiant(Etudiant etudiant) {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction=session.beginTransaction();
	session.persist(etudiant);
	transaction.commit();
	session.close();
	sessionFactory.close();
	return etudiant;
}

public void deleteEtudiant(Etudiant etudiant) {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction=session.beginTransaction();
	session.remove(etudiant);
	transaction.commit();
	session.close();
	sessionFactory.close();
}
}
