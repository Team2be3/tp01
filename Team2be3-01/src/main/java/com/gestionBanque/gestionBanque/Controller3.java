package com.gestionBanque.gestionBanque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gestionBanque.Metier.InterMetier;

@Controller
public class Controller3 {
	
	@Autowired
	private InterMetier metier;
	
	@RequestMapping(value="/")
	public String index(Model model){
    	
    	return "client";
    }
	@RequestMapping(value="/operation")
	public String indexOperation(Model model){
    
    	return "Operation";
	}
	
	@RequestMapping(value="/operationVirement")
	public String indexOperationVirement(Model model){
  
    	return "Operation";
    }
}
