package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LivretA extends Compte {

	@Column(name = "taux")
	private double taux;

	public LivretA() {
	}

	public LivretA(String numero, double solde, double taux) {
		super(numero, solde);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LivretA [taux=");
		builder.append(taux);
		builder.append("]");
		return builder.toString();
	}

}
