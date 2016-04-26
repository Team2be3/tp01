package com.gestionBanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*Auteur:Boumaza Alex
 * nom Projet :2be3
 *date:26/04/2016
 *Package:com.gestionBanque.entities
 *Class:Client
 *association:extends compte
 * 
 * */
@Entity
@DiscriminatorValue("Epargne")
public class CompteEpargne extends Compte {
	/* attributes */
	private double tauxInt;

	/* getEtSet */

	public double getTauxInt() {
		return tauxInt;
	}

	public void setTauxInt(double tauxInt) {
		this.tauxInt = tauxInt;
	}

	/* constructors */
	public CompteEpargne(double solde, Date dateCreation, double tauxInt) {
		super(solde, dateCreation);
		this.tauxInt = tauxInt;
	}

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

}
