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
		em.merge(g);
		em.merge(e);
		
		
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
		Query req=(Query) em.createQuery("from Compte cp where cp.client.idClient = :x");
		req.setParameter("x", idClient);
		return req.getResultList();
	}

	@Override
	public List<Compte> getListComCreEmp(Long idEmployer) {
		Query req=(Query) em.createQuery("from Compte cp where cp.employer.idEmployer = :x");
		req.setParameter("x", idEmployer);
		return req.getResultList();
	}

	@Override
	public List<Employer> getListEmployer() {
		Query req=(Query) em.createQuery("from Employer");
		return req.getResultList();
	}

	@Override
	public List<Employer> getListEmpParGro(Long idGroupe) {
		Query req=(Query) em.createQuery("select g.tabEmployer from Groupe g where g.idGroupe= :x");
		req.setParameter("x", idGroupe);
		return req.getResultList();
	}

	@Override
	public List<Groupe> getListGroupe() {
		Query req=(Query) em.createQuery("from Groupe");
		return req.getResultList();
	}

	@Override
	public List<Client> getListCliParMc(String mc) {
		Query req=(Query) em.createQuery("from Client c where c.nomClient like :x");
		req.setParameter("x", mc+"%");
		return req.getResultList();
	}

	@Override
	public Compte getCompte(Long idCompte) {
		Compte c=em.find(Compte.class,idCompte);
		return c;
	}	

}
