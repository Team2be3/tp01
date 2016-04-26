package com.gestionBanque.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/*Auteur:Dubuc Jérémy
 *nom Projet:Team2be3-01
 *date:26/04/2016
 *Package:com.gestionBanque.entities
 *Class:Groupe
 *version:1.
 *association:List<Employe>
 * */

@Entity
public class Groupe {
	
	/* attributes */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGroupe;
	private String nomGroupe;
	
	/* association */
	@ManyToMany
	List<Employer> tabEmployer= new ArrayList<Employer>();

	/* getEtSet */
	public Long getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Long idGroupe) {
		this.idGroupe = idGroupe;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public List<Employer> getTabEmployer() {
		return tabEmployer;
	}

	public void setTabEmployer(List<Employer> tabEmployer) {
		this.tabEmployer = tabEmployer;
	}

	/* constructors */
	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}

	public Groupe() {
		super();
	}
	
	
	
	
	
	

}
