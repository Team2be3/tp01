package com.gestionBanque.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;

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
		return req.list();
		
	}

	@Override
	public List<Compte> getListComParCli(Long idClient) {
		
	}

	@Override
	public List<Compte> getListComCreEmp(Long idEmployer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employer> getListEmployer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employer> getListEmpParGro(Long idGroupe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Groupe> getListGroupe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getListCliParMc(String mc) {
		Query req=(Query) em.createQuery("from Compte c where c.idClient like:x");
		req.setParameter("x", mc+"%");
		return req.list();
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
