package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.service.FactureService ;

@RestController
@RequestMapping("/facture")
public class FactureRestController {
	
	
	@Autowired
	FactureService factureService;
	
	// http://localhost:8089/SpringMVC/facture/retrieve-all-factures
	@GetMapping("/retrieve-all-factures")
	@ResponseBody
	public List<Facture> getAllFactures()
	{
		List<Facture> listFactures =factureService.retrieveAllFactures();
		return listFactures;
	}
	
	//http://localhost:8089/SpringMVC/facture/retrieve-facture/8
	@GetMapping("/retrieve-facture/{facture-id}")
	@ResponseBody
	public Facture retrieveFacture(@PathVariable("facture-id") Long idFacture) {
	return factureService.retrieveFacture(idFacture);
	}
	
	//http://localhost:8089/SpringMVC/facture/remove-facture/{facture-id}
	@DeleteMapping("/remove-facture/{facture-id}")
	@ResponseBody
	public void removeFacture(@PathVariable("facture-id") Long idFacture) {
		factureService.cancelFacture(idFacture);
	}
	

}
