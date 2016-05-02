package com.gestionBanque.gestionBanque;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller5 {
	
	@RequestMapping(value="/Login")
	public String seconnecter(){
		return "Login";	}
}
