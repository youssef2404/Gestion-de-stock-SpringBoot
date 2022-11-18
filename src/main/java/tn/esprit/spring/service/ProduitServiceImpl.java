package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.ProduitRepository;

@Service
@Slf4j
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository produitRepository;
	@Override
	public List<Produit> retrieveAllProduits() {
		
		return (List<Produit>)produitRepository.findAll();
	}

	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		
		return produitRepository.insertProduit(p, idRayon, idStock);
	}
	@Override
	public Produit addProduit(Produit p) {
		
		return (Produit)produitRepository.save(p);
	}

	@Override
	public Produit retrieveProduit(Long id) {
		return (Produit)produitRepository.findById(id).orElse(null);
		
	}
	

}
