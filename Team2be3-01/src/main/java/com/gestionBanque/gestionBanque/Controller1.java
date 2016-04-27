package com.gestionBanque.gestionBanque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestionBanque.Metier.InterMetier;

@Controller
public class Controller1 {
	
	@Autowired
	private InterMetier metier;
	
	@RequestMapping(value="/")
	public String index(Model model){
    	
    	return "client";
    }

}
