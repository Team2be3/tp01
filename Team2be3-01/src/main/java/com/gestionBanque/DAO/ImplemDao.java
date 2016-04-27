package com.gestionBanque.DAO;
/*Auteur:Loic Loichot
 * nom Projet:Team2be3
 *date:26/04/2016
 *Package:com.gestionVoiture.DAO
 *Class:ImplemDAO.
 *version:1.
 * 
 * */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import javax.persistence.Query;

import com.gestionBanque.entities.Client;
import com.gestionBanque.entities.Compte;
import com.gestionBanque.entities.Employer;
import com.gestionBanque.entities.Groupe;
import com.gestionBanque.entities.Operation;

public class ImplemDao implements InterDao {
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public void addClient(Client c) {
		em.persist(c);
		
	}

	@Override
	public void addEmployer(Employer e) {
		em.persist(e);
		
	}

	@Override
	public void addGroupe(Groupe g) {
		em.persist(g);
		
	}

	@Override
	public void addEmpToGro(Long idEmployer, Long idGroupe) {
		Employer e=em.find(Employer.class,idEmployer);
		Groupe g=em.find(Groupe.class, idGroupe);
		e.getTabGroupe().add(g);
		g.getTabEmployer().add(e);
		em.persist(g);
		em.persist(e);
		
		
	}

	@Override
	public void addCompte(Compte c, Long idClient, Long idEmployer) {
		Client cl=em.find(Client.class, idClient);
		Employer e=em.find(Employer.class, idEmployer);
		c.setClient(cl);
		c.setEmployer(e);
		em.persist(c);
		
		
	}

	@Override
	public void addOperation(Operation o, Long idCompte, Long idEmployer) {
		
		Compte c=em.find(Compte.class,idCompte);
		Employer e=em.find(Employer.class,idEmployer);
		o.setCompte(c);
		o.setEmploye(e);
		em.persist(o);
		
	}

	@Override
	public List<Compte> getListCompte() {
		Query req=(Query) em.createQuery("from Compte");
		return req.getResultList();
		
	}
	
	@Override
	public List<Compte> getListComParCli(Long idClient) {
		Client c=em.find(Client.class, idClient);
		return c.getTabCompte();
	}

	@Override
	public List<Compte> getListComCreEmp(Long idEmployer) {
		Employer e=em.find(Employer.class, idEmployer);
		return e.getTabCompte();
	}

	@Override
	public List<Employer> getListEmployer() {
		Query req=(Query) em.createQuery("from Employer");
		return req.getResultList();
	}

	@Override
	public List<Employer> getListEmpParGro(Long idGroupe) {
		Groupe g=em.find(Groupe.class, idGroupe);
		return g.getTabEmployer();
	}

	@Override
	public List<Groupe> getListGroupe() {
		Query req=(Query) em.createQuery("from Groupe");
		return req.getResultList();
	}

	@Override
	public List<Client> getListCliParMc(String mc) {
		Query req=(Query) em.createQuery("from Compte c where c.nomClient like:x");
		req.setParameter("x", mc+"%");
		return req.getResultList();
	}

	@Override
	public Compte getCompte(Long idCompte) {
		Compte c=em.find(Compte.class,idCompte);
		return c;
	}

	@Override
	public void updateCompte(Compte c) {
		em.merge(c);
		
	}

	

	

}
