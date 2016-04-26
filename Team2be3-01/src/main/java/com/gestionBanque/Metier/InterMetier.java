package com.gestionBanque.Metier;

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
	
	public void versement(double montant,Date dateOperation,Long idCompte,Long idEmployer);
	public void retrait(double montant,Date dateOperation,Long idCompte,Long idEmployer);
	public void virement(double montant,Date dateOperation,Long idCompteEm,Long idCompteRe,Long idEmployer);

}
