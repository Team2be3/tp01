package com.gestionBanque.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*Auteur:Boumaza Alex
 * nom Projet :2be3
 *date:26/04/2016
 *Package:com.gestionBanque.entities
 *Class:Client
 *association:List<Client>
 * 
 * */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeCompte", discriminatorType = DiscriminatorType.STRING)
public class Compte implements Serializable {
	/* attributes */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCompte;
	private double solde;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	/* association */
	@ManyToOne
	@JoinColumn(name="IdEmployer")
	private Employer employer;
	@ManyToOne
	@JoinColumn(name="IdClient")
	private Client client;
	@OneToMany(mappedBy="compte")
	private List<Operation> tabOperation= new ArrayList<Operation>();

	/* getEtSet */
	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Operation> getTabOperation() {
		return tabOperation;
	}

	public void setTabOperation(List<Operation> tabOperation) {
		this.tabOperation = tabOperation;
	}

	/* constructors */
	public Compte(double solde, Date dateCreation) {
		super();
		this.solde = solde;
		this.dateCreation = dateCreation;
	}

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

}
