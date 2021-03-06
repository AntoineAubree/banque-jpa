package fr.diginamic.entites;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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

	public Operation() {
	}

	public Operation(LocalDateTime date, double montant, String motif) {
		this.date = date;
		this.montant = montant;
		this.motif = motif;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Operation [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", montant=");
		builder.append(montant);
		builder.append(", motif=");
		builder.append(motif);
		builder.append("]");
		return builder.toString();
	}

}
