package com.gestionBanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*Auteur:Dubuc Jérémy
 *nom Projet:Team2be3-01
 *date:26/04/2016
 *Package:com.gestionBanque.entities
 *Class:Versement
 *version:1.
 *Class mère: operation
 * */

@Entity
@DiscriminatorValue(value="Versement")
public class Versement extends Operation{

	/* constructors */
	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Date dateOperation, double montant) {
		super(dateOperation, montant);
		// TODO Auto-generated constructor stub
	}

}
