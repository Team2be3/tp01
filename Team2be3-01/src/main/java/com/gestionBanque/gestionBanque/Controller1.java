package com.gestionBanque.gestionBanque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestionBanque.Metier.InterMetier;

@Controller
public class Controller1 {
	
	@Autowired
	private InterMetier metier;
	
	@RequestMapping(value="/")
	public String indexClient(Model model){
		model.addAttribute("cli",metier.getListCliParMc(""));	
    	return "client";
    }
	@RequestMapping(value="/client")
	public String index(Model model){
		model.addAttribute("cli",metier.getListCliParMc(""));
    	return "client";
    }
	
	@RequestMapping(value="/afficherCompteClient")
	public String index1(Model model, Long idClient){
		model.addAttribute("cli",metier.getListCliParMc(""));
		model.addAttribute("com",metier.getListComParCli(idClient));
    	return "client";
	}
	
	@RequestMapping(value="/clientMC")
	public String index1(Model model, String mc){
		model.addAttribute("cli",metier.getListCliParMc(mc));
    	return "client";
	}
	
}
