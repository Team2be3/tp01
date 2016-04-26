package com.gestionBanque.entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/*Auteur:Loic Loichot
 * nom Projet:Team2be3
 *date:26/04/2016
 *Package:com.gestionVoiture.entities
 *Class:CEmployer.
 *version:1.
 *association:List<Operation>,List<Compte>,List<Groupe>
 * 
 * */
@Entity
public class Employer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idEmployer;
private String nomEmployer;
@OneToMany
private ArrayList<Operation> tabOperation=new ArrayList<Operation>();
@OneToMany
private ArrayList<Compte> tabCompte=new ArrayList<Compte>();
@ManyToMany
private ArrayList<Groupe> tabGroupe=new ArrayList<Groupe>();

public Long getIdEmployer() {
	return idEmployer;
}
public void setIdEmployer(Long idEmployer) {
	this.idEmployer = idEmployer;
}
public String getNomEmployer() {
	return nomEmployer;
}
public void setNomEmployer(String nomEmployer) {
	this.nomEmployer = nomEmployer;
}

public ArrayList<Operation> getTabOperation() {
	return tabOperation;
}
public void setTabOperation(ArrayList<Operation> tabOperation) {
	this.tabOperation = tabOperation;
}
public ArrayList<Compte> getTabCompte() {
	return tabCompte;
}
public void setTabCompte(ArrayList<Compte> tabCompte) {
	this.tabCompte = tabCompte;
}
public ArrayList<Groupe> getTabGroupe() {
	return tabGroupe;
}
public void setTabGroupe(ArrayList<Groupe> tabGroupe) {
	this.tabGroupe = tabGroupe;
}
public Employer(String nomEmployer) {
	super();
	this.nomEmployer = nomEmployer;
}
public Employer() {
	super();
}

}
