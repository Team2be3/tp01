package com.gestionBanque.entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
private ArrayList<Operation> tabo=new ArrayList<>();
@OneToMany
private ArrayList<Compte> tabc=new ArrayList<>();
@ManyToMany
private ArrayList<Groupe> tabg=new ArrayList<>();
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
public ArrayList<Operation> getTabo() {
	return tabo;
}
public void setTabo(ArrayList<Operation> tabo) {
	this.tabo = tabo;
}
public ArrayList<Compte> getTabc() {
	return tabc;
}
public void setTabc(ArrayList<Compte> tabc) {
	this.tabc = tabc;
}
public ArrayList<Groupe> getTabg() {
	return tabg;
}
public void setTabg(ArrayList<Groupe> tabg) {
	this.tabg = tabg;
}
public Employer(String nomEmployer) {
	super();
	this.nomEmployer = nomEmployer;
}
public Employer() {
	super();
}

}
