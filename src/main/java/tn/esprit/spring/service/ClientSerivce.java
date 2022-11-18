package tn.esprit.spring.service;


import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Client;

@Service
public interface ClientSerivce {
	
	List<Client> retrieveAllClients();

	Client addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client c);

	Client retrieveClient(Long id);
	
	 List<Client> retrieveClientsByDateNaissance(String d1,String d2) throws ParseException ;

}
