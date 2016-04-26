package com.gestionBanque.Metier;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.gestionBanque.DAO.InterDao;
import com.gestionBanque.entities.Client;
import com.gestionBanque.entities.Compte;
import com.gestionBanque.entities.Employer;
import com.gestionBanque.entities.Groupe;

@Transactional
public class ImplemMetier implements InterMetier {
	
	private final Logger LOG=Logger.getLogger("ImplemMetier");
	private InterDao dao;
	
	public void setDao(InterDao dao) {
		this.dao = dao;
		LOG.info("dao client injected");
	}

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

	@Override
	public void versement(double montant, Date dateOperation, Long idCompte,
			Long idEmployer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void retrait(double montant, Date dateOperation, Long idCompte,
			Long idEmployer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void virement(double montant, Date dateOperation, Long idCompteEm,
			Long idCompteRe, Long idEmployer) {
		// TODO Auto-generated method stub

	}

}
