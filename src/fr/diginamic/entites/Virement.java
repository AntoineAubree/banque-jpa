package fr.diginamic.entites;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
public class Virement extends Operation {

	@JoinColumn(name = "beneficiaire")
	private String beneficiaire;

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
		builder.append("]");
		return builder.toString();
	}

}
