package com.gestionBanque.gestionBanque;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestionBanque.Metier.InterMetier;
import com.gestionBanque.entities.Client;
import com.gestionBanque.entities.CompteCourant;
import com.gestionBanque.entities.CompteEpargne;
import com.gestionBanque.entities.Employer;
import com.gestionBanque.entities.Groupe;

@Controller
public class Controller2 {
	
	@Autowired
	private InterMetier metier;
	
	@RequestMapping(value="/employer")
	public String indexEmployer(Model model){
		model.addAttribute("client", metier.getListCliParMc(""));
		model.addAttribute("employer", metier.getListEmployer());
		model.addAttribute("compte", metier.getListCompte());
		model.addAttribute("groupe", metier.getListGroupe());
		
    	return "Employer";
    }
	
	@RequestMapping(value="/insererClient")
	public String insererClient(Model model, String nomClient, String prenomClient, String dateNaissance, String adresse) throws ParseException{
		SimpleDateFormat SDF=new SimpleDateFormat("yyyy-MM-dd");
		Date dateNaisb=SDF.parse(dateNaissance);
		metier.addClient(new Client(nomClient, prenomClient, dateNaisb, adresse));
		
		
		model.addAttribute("client", metier.getListCliParMc(""));
		model.addAttribute("employer", metier.getListEmployer());
		model.addAttribute("compte", metier.getListCompte());
		model.addAttribute("groupe", metier.getListGroupe());
    	return "Employer";
    }
	
	@RequestMapping(value="/insererCompteCourant")
	public String insererCompteCourant(Model model, String solde, String decouvert, String idClient, String idEmployer){
		double soldeb= Double.parseDouble(solde);
		double decouvertb= Double.parseDouble(decouvert);
		Long idC=Long.parseLong(idClient);
		Long idE=Long.parseLong(idEmployer);
		metier.addCompte(new CompteCourant(soldeb, new Date(), decouvertb), idC, idE);
		
		model.addAttribute("client", metier.getListCliParMc(""));
		model.addAttribute("employer", metier.getListEmployer());
		model.addAttribute("compte", metier.getListCompte());
		model.addAttribute("groupe", metier.getListGroupe());
    	return "Employer";
    }
	
	@RequestMapping(value="/insererCompteEpargne")
	public String insererCompteEpargne(Model model, String solde, String tauxInt, String idClient, String idEmployer){
		double soldeb= Double.parseDouble(solde);
		double tauxIntb= Double.parseDouble(tauxInt);
		Long idC=Long.parseLong(idClient);
		Long idE=Long.parseLong(idEmployer);
		metier.addCompte(new CompteEpargne(soldeb, new Date(), tauxIntb), idC, idE);
		
		model.addAttribute("client", metier.getListCliParMc(""));
		model.addAttribute("employer", metier.getListEmployer());
		model.addAttribute("compte", metier.getListCompte());
		model.addAttribute("groupe", metier.getListGroupe());
    	return "Employer";
    }
	
	@RequestMapping(value="/afficherCompteCreEmp")
	public String afficherCompteCreEmp(Model model, Long idEmployer){
		model.addAttribute("comcre", metier.getListComCreEmp(idEmployer));
		model.addAttribute("client", metier.getListCliParMc(""));
		model.addAttribute("employer", metier.getListEmployer());
		model.addAttribute("compte", metier.getListCompte());
		model.addAttribute("groupe", metier.getListGroupe());
		return "Employer";
    }
	
	@RequestMapping(value="/afficherEmpParGro")
	public String afficherEmpParGro(Model model, Long idGroupe){
		model.addAttribute("empgro", metier.getListEmpParGro(idGroupe));
		
		model.addAttribute("client", metier.getListCliParMc(""));
		model.addAttribute("employer", metier.getListEmployer());
		model.addAttribute("compte", metier.getListCompte());
		model.addAttribute("groupe", metier.getListGroupe());
    	return "Employer";
    }
	
	@RequestMapping(value="/ajouterEmployer")
	public String ajouterEmployer(Model model, Employer e){
		metier.addEmployer(e);
		
		model.addAttribute("client", metier.getListCliParMc(""));
		model.addAttribute("employer", metier.getListEmployer());
		model.addAttribute("compte", metier.getListCompte());
		model.addAttribute("groupe", metier.getListGroupe());
    	return "Employer";
    }
	
	@RequestMapping(value="/ajouterGroupe")
	public String ajouterGroupe(Model model, Groupe g){
		metier.addGroupe(g);
		
		model.addAttribute("client", metier.getListCliParMc(""));
		model.addAttribute("employer", metier.getListEmployer());
		model.addAttribute("compte", metier.getListCompte());
		model.addAttribute("groupe", metier.getListGroupe());
    	return "Employer";
    }
	
	@RequestMapping(value="/ajouterEmplGro")
	public String ajouterEmplGro(Model model, String idEmployer, String idGroupe){
		Long idE=Long.parseLong(idEmployer);
		Long idG=Long.parseLong(idGroupe);
		metier.addEmpToGro(idE, idG);
		
		model.addAttribute("client", metier.getListCliParMc(""));
		model.addAttribute("employer", metier.getListEmployer());
		model.addAttribute("compte", metier.getListCompte());
		model.addAttribute("groupe", metier.getListGroupe());
    	return "Employer";
    }
}
