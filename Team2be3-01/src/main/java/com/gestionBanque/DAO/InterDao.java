package com.gestionBanque.DAO;
/*Auteur:Loic Loichot
 * nom Projet:Team2be3
 *date:26/04/2016
 *Package:com.gestionVoiture.entities
 *Class:interDAO.
 *version:1.
 * 
 * */
import java.util.List;

import com.gestionBanque.entities.Client;
import com.gestionBanque.entities.Compte;
import com.gestionBanque.entities.CompteCourant;
import com.gestionBanque.entities.Employer;
import com.gestionBanque.entities.Groupe;
import com.gestionBanque.entities.Operation;

public interface InterDao {
	
	public void addClient(Client c); //ajoute un client c
	public void addEmployer(Employer e);// ajoute un employer e
	public void addGroupe(Groupe g);// ajoute un groupe g
	public void addEmpToGro(Long idEmployer,Long idGroupe);//associe groupe et employer
	public void addCompte(Compte c,Long idClient,Long idEmployer);//associe un compte avec un client et un employer
	public void addOperation(Operation o,Long idCompte,Long idEmployer);// ajouter une operation associe a une compte et un employer
	public List<Compte> getListCompte();//obtient la liste des comptes
	public List<Compte> getListComParCli(Long idClient);//obtient la liste des comptes par clients
	public List<Compte> getListComCreEmp(Long idEmployer);//obtient la liste des comptes creer par employer
	public List<Employer> getListEmployer();//obtient la liste des employer
	public List<Employer> getListEmpParGro(Long idGroupe);//obtient la liste des employer par groupe
	public List<Groupe> getListGroupe();//obtient la liste des groupe
	public List<Client> getListCliParMc(String mc);//obtient la liste des client dont le nom commence par mc
	
	public Compte getCompte(Long idCompte);// obtient un compte c
	public CompteCourant getCompteCourant(Long idCompte);// obtient un compte courant
}
