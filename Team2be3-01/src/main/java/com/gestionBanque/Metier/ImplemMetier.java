package com.gestionBanque.Metier;

/*Auteur:Dubuc J�r�my
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
		Versement v= new Versement(dateOperation, montant);
		Compte c=dao.getCompte(idCompte);
		double s=c.getSolde()+montant;
		c.setSolde(s);
		dao.updateCompte(c);
		dao.addOperation(v, idCompte, idEmployer);

	}

	@Override
	public void retrait(double montant, Date dateOperation, Long idCompte,
			Long idEmployer) {
		Retrait r= new Retrait(dateOperation, montant);
		Compte c=dao.getCompte(idCompte);
		double s=c.getSolde()-montant;
		c.setSolde(s);
		dao.updateCompte(c);
		dao.addOperation(r, idCompte, idEmployer);
	}

	@Override
	public void virement(double montant, Date dateOperation, Long idCompteEm,
			Long idCompteRe, Long idEmployer) {
		retrait(montant,dateOperation,idCompteEm,idEmployer);
		versement(montant,dateOperation,idCompteRe,idEmployer);
	}

}
