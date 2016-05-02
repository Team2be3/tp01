package com.gestionBanque.gestionBanque;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		
		model.addAttribute("ajoutemp", new Employer());
		
    	return "Employer";
    }
	
	@RequestMapping(value="/insererClient")
	public String insererClient(Model model, String nomClient, String prenomCLient,
								String dateNaissance, String adresse,BindingResult resultat) throws ParseException{
		
		model.addAttribute("client", metier.getListCliParMc(""));
		model.addAttribute("employer", metier.getListEmployer());
		model.addAttribute("compte", metier.getListCompte());
		model.addAttribute("groupe", metier.getListGroupe());
		
		SimpleDateFormat SDF=new SimpleDateFormat("yyyy-MM-dd");
		Date dateNaisb=SDF.parse(dateNaissance);
		metier.addClient(new Client(nomClient, prenomCLient, dateNaisb, adresse));
		
    	return "redirect:employer";
    }
	
	@RequestMapping(value="/insererCompteCourant")
	public String insererCompteCourant(Model model, double solde, double decouvert, Long idClient, Long idEmployer){
		metier.addCompte(new CompteCourant(solde, new Date(), decouvert), idClient, idEmployer);
		
		model.addAttribute("client", metier.getListCliParMc(""));
		model.addAttribute("employer", metier.getListEmployer());
		model.addAttribute("compte", metier.getListCompte());
		model.addAttribute("groupe", metier.getListGroupe());
    	return "Employer";
    }
	
	@RequestMapping(value="/insererCompteEpargne")
	public String insererCompteEpargne(Model model, double solde, double tauxInt, Long idClient, Long idEmployer){
		metier.addCompte(new CompteEpargne(solde, new Date(), tauxInt), idClient, idEmployer);
		
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
	public String ajouterEmployer(Model model,@ModelAttribute("ajoutemp") @Valid Employer e,BindingResult resultat){
		
		
		model.addAttribute("client", metier.getListCliParMc(""));
		model.addAttribute("employer", metier.getListEmployer());
		model.addAttribute("compte", metier.getListCompte());
		model.addAttribute("groupe", metier.getListGroupe());
		
		if(resultat.hasErrors()){
			return "Employer";
		}
		metier.addEmployer(e);
    	return "redirect:employer";
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
	public String ajouterEmplGro(Model model, Long idEmployer, Long idGroupe){
		metier.addEmpToGro(idEmployer, idGroupe);
		
		model.addAttribute("client", metier.getListCliParMc(""));
		model.addAttribute("employer", metier.getListEmployer());
		model.addAttribute("compte", metier.getListCompte());
		model.addAttribute("groupe", metier.getListGroupe());
    	return "Employer";
    }
}
