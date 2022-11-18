package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.FactureRepository;

@Service
@Slf4j
public class FactureServiceImpl implements FactureService {

	@Autowired
	FactureRepository factureRepository;
	@Override
	public List<Facture> retrieveAllFactures() {
		
		return (List<Facture>)factureRepository.findAll();
	}

	@Override
	public void cancelFacture(Long id) {
		factureRepository.cancelFacture(id);
		
	}

	@Override
	public Facture retrieveFacture(Long id) {
		return (Facture)factureRepository.findById(id).orElse(null);
		 
	}

}
