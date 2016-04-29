package com.gestionBanque.Metier;

/*Auteur:Dubuc Jérémy
 *nom Projet:Team2be3-01
 *date:26/04/2016
 *Package:com.gestionBanque.Metier
 *ImplemMetier
 *version:1. 
 * */

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.gestionBanque.DAO.InterDao;
import com.gestionBanque.entities.Client;
import com.gestionBanque.entities.Compte;
import com.gestionBanque.entities.CompteCourant;
import com.gestionBanque.entities.Employer;
import com.gestionBanque.entities.Groupe;
import com.gestionBanque.entities.Retrait;
import com.gestionBanque.entities.Versement;

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
		
		dao.addClient(c);

	}

	@Override
	public void addEmployer(Employer e) {

		dao.addEmployer(e);

	}

	@Override
	public void addGroupe(Groupe g) {
		
		dao.addGroupe(g);
		
	}

	@Override
	public void addEmpToGro(Long idEmployer, Long idGroupe) {

		dao.addEmpToGro(idEmployer, idGroupe);

	}

	@Override
	public void addCompte(Compte c, Long idClient, Long idEmployer) {

		dao.addCompte(c, idClient, idEmployer);

	}

	@Override
	public List<Compte> getListCompte() {
		
		return dao.getListCompte();
	}

	@Override
	public List<Compte> getListComParCli(Long idClient) {
		
		return dao.getListComParCli(idClient);
	}

	@Override
	public List<Compte> getListComCreEmp(Long idEmployer) {
		
		return dao.getListComCreEmp(idEmployer);
	}

	@Override
	public List<Employer> getListEmployer() {
		
		return dao.getListEmployer();
	}

	@Override
	public List<Employer> getListEmpParGro(Long idGroupe) {
		
		return dao.getListEmpParGro(idGroupe);
	}

	@Override
	public List<Groupe> getListGroupe() {
		
		return dao.getListGroupe();
	}

	@Override
	public List<Client> getListCliParMc(String mc) {
		// TODO Auto-generated method stub
		return dao.getListCliParMc(mc);
	}
	
	@Override
	public Compte getCompte(Long idCompte) {
		
		return dao.getCompte(idCompte);
	}

	@Override
	public void versement(double montant, Date dateOperation, Long idCompte,
			Long idEmployer) {
		
		dao.addOperation(new Versement(dateOperation, montant), idCompte, idEmployer);
		Compte c=dao.getCompte(idCompte);
		c.setSolde(c.getSolde()+montant);
	}

	@Override
	public void retrait(double montant, Date dateOperation, Long idCompte,
			Long idEmployer) throws Exception {
		dao.addOperation(new Retrait(dateOperation, montant), idCompte, idEmployer);
		Compte c=dao.getCompte(idCompte);
		double solde=c.getSolde()-montant;
		if (c.getClass().getSimpleName().equals("CompteCourant")){
			CompteCourant cc=dao.getCompteCourant(idCompte);
			if (solde<-cc.getDecouvert()) throw new Exception("Solde insuffisant");
			else cc.setSolde(solde);
		}
		else if (solde<0) throw new Exception("Solde insuffisant");
		else c.setSolde(solde);
	}

	@Override
	public void virement(double montant, Date dateOperation, Long idCompteEm,
			Long idCompteRe, Long idEmployer) throws Exception {
		retrait(montant,dateOperation,idCompteEm,idEmployer);
		versement(montant,dateOperation,idCompteRe,idEmployer);
	}

	

}
