package com.gestionBanque.Metier;

/*Auteur:Dubuc Jérémy
 *nom Projet:Team2be3-01
 *date:26/04/2016
 *Package:com.gestionBanque.Metier
 *InterMetier
 *version:1.
 * */

import java.util.Date;
import java.util.List;

import com.gestionBanque.entities.Client;
import com.gestionBanque.entities.Compte;
import com.gestionBanque.entities.Employer;
import com.gestionBanque.entities.Groupe;

public interface InterMetier {
	
	public void addClient(Client c);
	public void addEmployer(Employer e);
	public void addGroupe(Groupe g);
	public void addEmpToGro(Long idEmployer,Long idGroupe);
	public void addCompte(Compte c,Long idClient,Long idEmployer);
	public List<Compte> getListCompte();
	public List<Compte> getListComParCli(Long idClient);
	public List<Compte> getListComCreEmp(Long idEmployer);
	public List<Employer> getListEmployer();
	public List<Employer> getListEmpParGro(Long idGroupe);
	public List<Groupe> getListGroupe();
	public List<Client> getListCliParMc(String mc);
	
	public Compte getCompte(Long idCompte);
	
	public void versement(double montant,Date dateOperation,Long idCompte,Long idEmployer);
	public void retrait(double montant,Date dateOperation,Long idCompte,Long idEmployer) throws Exception;
	public void virement(double montant,Date dateOperation,Long idCompteEm,Long idCompteRe,Long idEmployer) throws Exception;

}
