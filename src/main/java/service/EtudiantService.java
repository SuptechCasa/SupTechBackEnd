package service;

import java.util.ArrayList;
import java.util.List;

import dao.EtudiantDao;
import model.Etudiant;

public class EtudiantService {
EtudiantDao etudiantDao;
public EtudiantService() {
	etudiantDao=new EtudiantDao();
	
}

public List<Etudiant> getAllEtudiants(){
	return etudiantDao.getAllEtudiants();
}

public Etudiant addEtudiant(Etudiant etudiant) {
	return etudiantDao.addEtudiant(etudiant);
}

public void deleteEtudiant(Etudiant etudiant) {
	etudiantDao.deleteEtudiant(etudiant);
}
}
