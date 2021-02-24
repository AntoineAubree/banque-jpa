package fr.diginamic.entites;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
public class Virement extends Operation {

	@JoinColumn(name = "beneficiaire")
	private String beneficiaire;
	
	public Virement() {
	}

	
	
	public Virement(LocalDateTime date, double montant, String motif, String beneficiaire) {
		super(date, montant, motif);
		this.beneficiaire = beneficiaire;
	}



	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Virement [beneficiaire=");
		builder.append(beneficiaire);
		builder.append(" ");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	

}
