package com.gestionBanque.entities;

/*Auteur:Boumaza Alex
 * nom Projet :2be3
 *date:26/04/2016
 *Package:com.gestionBanque.entities
 *Class:Client
 *association:extends compte
 * 
 * */
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Courant")
public class CompteCourant extends Compte {
	/* attributes */
	private double decouvert;

	/* getEtSet */

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	/* constructors */
	public CompteCourant(double solde, Date dateCreation, double decouvert) {
		super(solde, dateCreation);
		this.decouvert = decouvert;
	}

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(double solde, Date dateCreation) {
		super(solde, dateCreation);
		// TODO Auto-generated constructor stub
	}

}
