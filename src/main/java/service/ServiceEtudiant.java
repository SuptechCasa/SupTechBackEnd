package service;

import java.util.ArrayList;
import java.util.List;

import model.Etudiant;

public class ServiceEtudiant {
List<Etudiant> etudiants;
public ServiceEtudiant() {
	this.etudiants=new ArrayList();
}

public List<Etudiant> getAllEtudiants(){
	return this.etudiants;
}

public Etudiant addEtudiant(Etudiant etudiant) {
	this.etudiants.add(etudiant);
	return etudiant;
}
}
