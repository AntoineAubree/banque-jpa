package fr.diginamic.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Client {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "date_naissance")
	private LocalDate dateNaissance;
	@ManyToMany
	@JoinTable(name = "compte_client", 
		joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id"))
	private List<Compte> comptes = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "id_banque")
	private Banque banque;

}
