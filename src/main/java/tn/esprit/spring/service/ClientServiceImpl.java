package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.ClientRepository;

@Service
@Slf4j
public class ClientServiceImpl implements ClientSerivce{

	@Autowired
	ClientRepository Clientrepository;
	@Override
	public List<Client> retrieveAllClients() {
		return  (List<Client>)Clientrepository.findAll();
		
	}

	@Override
	public Client addClient(Client c) {
		return (Client)Clientrepository.save(c);
		
	}

	@Override
	public void deleteClient(Long id) {
		Clientrepository.deleteById(id);
		
	}

	@Override
	public Client updateClient(Client c) {
		return (Client)Clientrepository.save(c);
		
	}

	@Override
	public Client retrieveClient(Long id) {
		
		return (Client)Clientrepository.findById(id).orElse(null);
	}
	@Override
	public List<Client> retrieveClientsByDateNaissance(String d1,String d2) throws ParseException {
		SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = d.parse(d1);
		Date date2 = d.parse(d2);
		return Clientrepository.retrieveClientsByDateNaissance(date1, date2);
		
	}

}
