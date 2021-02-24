package fr.diginamic.entites;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Operation {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "date")
	private LocalDateTime date;
	@Column(name = "montant")
	private double montant;
	@Column(name = "motif")
	private String motif;
	@ManyToOne
	@JoinColumn(name = "id_compte")
	private Compte compte;

}
