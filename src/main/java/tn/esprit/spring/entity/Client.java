package tn.esprit.spring.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;



import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client implements Serializable{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idClient;
		private String nom;
		private String prenom;
		@Temporal(TemporalType.DATE)
		private Date dateNaissance;
		private String email;
		private String password;
		@Enumerated(EnumType.STRING)
		private CategorieClient categorieclient ;
		@Enumerated(EnumType.STRING)
		private Profession profession;

	
		@OneToMany(mappedBy="client",cascade=CascadeType.ALL)
		private Set <Facture>Factures;
		
		
		
		
		
		
		
}
