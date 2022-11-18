package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit,Long> {

	@Modifying
	@Query(value="INSERT INTO Produit (Produit,idRayon,idStock) values (:Produit,:idRayon,:idStock)",
	nativeQuery=true)
	Produit insertProduit(@Param("Produit")Produit Produit,@Param("idRayon")Long idRayon,
			@Param("idStock")Long idStock);
	
}
