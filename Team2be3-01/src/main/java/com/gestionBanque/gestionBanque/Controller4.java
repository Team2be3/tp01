package com.gestionBanque.gestionBanque;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestionBanque.Metier.InterMetier;
import com.gestionBanque.entities.Employer;

@Controller
public class Controller4 {
	
	@Autowired
	private InterMetier metier;
	
	@RequestMapping(value="/")
	public String indexaccueil(Model model){
		
    	return "accueil";
    }
	@RequestMapping(value="/accueil")
	public String indexaccueils(Model model){
		//
    	return "accueil";
    }
	@RequestMapping(value="/login")
	public String login(Model model, String id, String nom){
		Long id1=Long.parseLong(id);
		String p="accueil";
		for (Employer e:metier.getListEmployer()){
			if((e.getIdEmployer()==id1) && (e.getNomEmployer().equals(nom))){
				p="Employer";
				model.addAttribute("client", metier.getListCliParMc(""));
				model.addAttribute("employer", metier.getListEmployer());
				model.addAttribute("compte", metier.getListCompte());
				model.addAttribute("groupe", metier.getListGroupe());
			}
		}
		model.addAttribute("message","Saisie incorrecte");
		model.addAttribute("messageb",3);
		return p;
    	
    }
}
