package com.gestionBanque.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEmployer(Employer e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGroupe(Groupe g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEmpToGro(Long idEmployer, Long idGroupe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCompte(Compte c, Long idClient, Long idEmployer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOperation(Operation o, Long idCompte, Long idEmployer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Compte> getListCompte() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> getListComParCli(Long idClient) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
