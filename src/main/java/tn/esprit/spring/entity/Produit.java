package tn.esprit.spring.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produit implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit;
	private String codeProduit;
	private String libelleProduit;
	private float PrixUnitaire;

	@ManyToOne
	private Rayon Rayon;
	@ManyToOne
	private Stock Stock;
	@ManyToMany(cascade=CascadeType.ALL)
	private Set <Fournisseur>Fournisseurs;
	@OneToOne
	private DetailProduit DetailProduit ;
	@OneToMany(mappedBy="produit",cascade=CascadeType.ALL)
	private Set <DetailFacture>DetailFactures;
	

}

