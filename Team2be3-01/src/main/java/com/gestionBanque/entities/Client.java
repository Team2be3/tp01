package com.gestionBanque.entities;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*Auteur:Loic Loichot
 * nom Projet:Team2be3
 *date:26/04/2016
 *Package:com.gestionVoiture.entities
 *Class:Client.
 *version:1.
 *association:List<Compte>
 * 
 * */
@Entity
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idClient;
private String nomClient;    //Attributs
private String prenomCLient;
@Temporal(TemporalType.DATE)
private Date dateNaissance;
private String adresse;
@OneToMany
private ArrayList<Compte> tabc=new ArrayList<>();



public Long getIdClient() {
	return idClient;
}
public void setIdClient(Long idClient) {
	this.idClient = idClient;
}
public String getNomClient() {
	return nomClient;
}                                                                                   //get et set
public void setNomClient(String nomClient) {
	this.nomClient = nomClient;
}
public String getPrenomCLient() {
	return prenomCLient;
}
public void setPrenomCLient(String prenomCLient) {
	this.prenomCLient = prenomCLient;
}
public Date getDateNaissance() {
	return dateNaissance;
}
public void setDateNaissance(Date dateNaissance) {
	this.dateNaissance = dateNaissance;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public ArrayList<Compte> getTabc() {
	return tabc;
}
public void setTabc(ArrayList<Compte> tabc) {
	this.tabc = tabc;
}
public Client(String nomClient, String prenomCLient, Date dateNaissance,
		String adresse) {
	super();
	this.nomClient = nomClient;
	this.prenomCLient = prenomCLient;
	this.dateNaissance = dateNaissance;
	this.adresse = adresse;
}
public Client() {
	super();
}

}
