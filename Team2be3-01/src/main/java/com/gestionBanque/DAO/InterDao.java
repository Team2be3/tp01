package com.gestionBanque.DAO;

import java.util.List;

import com.gestionBanque.entities.Client;
import com.gestionBanque.entities.Compte;
import com.gestionBanque.entities.Employer;
import com.gestionBanque.entities.Groupe;
import com.gestionBanque.entities.Operation;

public interface InterDao {
	
	public void addClient(Client c);
	public void addEmployer(Employer e);
	public void addGroupe(Groupe g);
	public void addEmpToGro(Long idEmployer,Long idGroupe);
	public void addCompte(Compte c,Long idClient,Long idEmployer);
	public void addOperation(Operation o,Long idCompte,Long idEmployer);
	public List<Compte> getListCompte();
	public List<Compte> getListComParCli(Long idClient);
	public List<Compte> getListComCreEmp(Long idEmployer);
	public List<Employer> getListEmployer();
	public List<Employer> getListEmpParGro(Long idGroupe);
	public List<Groupe> getListGroupe();
	public List<Client> getListCliParMc(String mc);
	
	public Compte getCompte(Long idCompte);
	public void updateCompte(Compte c);
	
}
