package com.gestionBanque.gestionBanque;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gestionBanque.Metier.InterMetier;
import com.gestionBanque.entities.Operation;
import com.gestionBanque.entities.Retrait;

@Controller
public class Controller3 {
	
	@Autowired
	private InterMetier metier;
	@RequestMapping(value="/operation")
	public String indexOperation(Model model){
		model.addAttribute("compte", metier.getListCompte());
		model.addAttribute("employer", metier.getListEmployer());
    	return "Operation";
	}
	
	@RequestMapping(value="/operationVirement")
	public String indexOperationVirement(Model model,String montant, String dateOperation,String idCompte1,String idCompte2, String idEmployer) throws Exception{
    SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
    Date d1=sd.parse(dateOperation);
    double mt=Double.parseDouble(montant);
    Long id1=Long.parseLong(idCompte1);
    Long id2=Long.parseLong(idCompte2);
    Long idEm=Long.parseLong(idEmployer);
    metier.virement(mt, d1, id1, id2, idEm);
    
	model.addAttribute("client", metier.getListCliParMc(""));
	model.addAttribute("employer", metier.getListEmployer());
	model.addAttribute("compte", metier.getListCompte());
	model.addAttribute("groupe", metier.getListGroupe());
    	return "Employer";
	}
	
	@RequestMapping(value="/operationRetrait")
	public String indexOperationRetrait(Model model,String montant, String dateOperation,String idCompte, String idEmployer) throws Exception{
		try {
			SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		    Date d1=sd.parse(dateOperation);
		    double mt=Double.parseDouble(montant);
		    Long idC=Long.parseLong(idCompte);
		    Long idEm=Long.parseLong(idEmployer);
		   

		    metier.retrait(mt, d1, idC, idEm);
		} catch (Exception e) {
			
			Operation o=new Retrait();
			o.setException(e.getMessage());
			model.addAttribute("op", o);
		}
	    
		model.addAttribute("client", metier.getListCliParMc(""));
		model.addAttribute("employer", metier.getListEmployer());
		model.addAttribute("compte", metier.getListCompte());
		model.addAttribute("groupe", metier.getListGroupe());
    	return "Operation";
    }
	@RequestMapping(value="/operationVersement")
	public String indexOperationVersement(Model model,String montant, String dateOperation,String idCompte, String idEmployer) throws Exception{
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
	    Date d1=sd.parse(dateOperation);
	    double mt=Double.parseDouble(montant);
	    Long idC=Long.parseLong(idCompte);
	    Long idEm=Long.parseLong(idEmployer);
	    metier.versement(mt, d1, idC, idEm);
	    
		model.addAttribute("client", metier.getListCliParMc(""));
		model.addAttribute("employer", metier.getListEmployer());
		model.addAttribute("compte", metier.getListCompte());
		model.addAttribute("groupe", metier.getListGroupe());
    	return "Employer";
    }
	
	
	}

