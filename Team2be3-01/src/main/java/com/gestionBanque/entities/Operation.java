package com.gestionBanque.entities;

/*Auteur:Dubuc Jérémy
 *nom Projet:Team2be3-01
 *date:26/04/2016
 *Package:com.gestionBanque.entities
 *Class:Operation
 *version:1.
 *association:Employe,Compte
 * */

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Inheritance
@DiscriminatorColumn(name="TypeOperation",discriminatorType=DiscriminatorType.STRING)
public class Operation {
	/* attributes */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOperation;
	@Temporal(TemporalType.DATE)
	private Date dateOperation;
	private double montant;
	@Transient
	private String exception;
	
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	/* association */
	@ManyToOne
	@JoinColumn(name="IdCompte")
	private Compte compte;
	@ManyToOne
	@JoinColumn(name="IdEmployer")
	private Employer employe;
	
	/* getEtSet */
	public Long getIdOperation() {
		return idOperation;
	}
	public void setIdOperation(Long idOperation) {
		this.idOperation = idOperation;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Employer getEmploye() {
		return employe;
	}
	public void setEmploye(Employer employe) {
		this.employe = employe;
	}
		
	/* constructors */
	public Operation(Date dateOperation, double montant) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
	}
	public Operation() {
		super();
	}
	
}
