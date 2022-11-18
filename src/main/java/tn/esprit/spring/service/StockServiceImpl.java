package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;

@Service
@Slf4j
public class StockServiceImpl implements StockService{

	@Autowired
	StockRepository stockRepository;
	@Override
	public List<Stock> retrieveAllStocks() {
		
		return  (List<Stock>)stockRepository.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		
		return(Stock)stockRepository.save(s);
	}

	@Override
	public Stock updateStock(Stock u) {
		return(Stock)stockRepository.save(u);
	}

	@Override
	public Stock retrieveStock(Long id) {
		return(Stock)stockRepository.findById(id).orElse(null);
	}
	//Les tâches sont déclenchées avec un retard de 60 secondes.
	@Scheduled(fixedDelay = 60000)
	public void fixedDelayMethod() {

	log.info("Method with fixed delay");

	}
	//exécuter la méthode toutes les 60 secondes
	@Scheduled(fixedRate = 60000)
	public void fixedRateMethod() {

	log.info("Method with fixed Rate");
	}
	//1/ exécuter la tâche à chaque minute 15e seconde.
	
	@Scheduled(cron = "15 * * * * *")
	public void fixedcrond1() 
	{
		log.info("cron1");
	}
 @Scheduled(cron = "*/15 * * * * *")
 //2/exécute la tâche pour chaque intervalle de 15 secondes.
 public void fixedcrond2() 
	{
		log.info("cron2");
	}
 //3/exécute une tâche pour commencer l'exécution à la 0e seconde de chaque minute et l'exécute également avec un intervalle de 15 secondes.
	 @Scheduled(cron ="0/15 * * * * *")
	 public void fixedcron3() 
		{
			log.info("cron3");
		}
	//4/exécute la tâche pour Chaque jour 11h et répète avec un intervalle de 30 minutes.
	 @Scheduled(cron ="0 0/30 11 * * *")
	 public void fixedcron4() 
		{
			log.info("cron4");
		}
//	5/ exécute une tâche tous les ans en avril, tous les jours à 8 heures du matin.

	@Scheduled(cron = "0 0 8 ? 4 ?") //or (cron = "0 0 8 * 4 *")
	public void fixedcrond5() 
	{
		log.info("cron5");
	}
//6/exécute une tâche chaque année le 14 février à 9AM si le jour donné (14) est un dimanche ou un mardi seulement.
 @Scheduled(cron = " 0 0 9 14 2 SUN,TUE")
 public void fixedcrond6() 
	{
		log.info("cron6");
	}

}
