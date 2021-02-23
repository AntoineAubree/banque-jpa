package fr.diginamic.entites;

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

@Entity
public class Compte {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "numero")
	private String numero;
	@Column(name = "solde")
	private double solde;
	@ManyToMany
	@JoinTable(name = "compte_client", 
		joinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"))
	private List<Client> clients = new ArrayList<>();

}
