package fr.diginamic.entites;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
public class AssuranceVie extends Compte {

	@JoinColumn(name = "taux")
	private double taux;
	@JoinColumn(name = "date_fin")
	private LocalDate dateFin;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AssuranceVie [taux=");
		builder.append(taux);
		builder.append(", dateFin=");
		builder.append(dateFin);
		builder.append("]");
		return builder.toString();
	}

}
