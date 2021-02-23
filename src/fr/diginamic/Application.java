package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.utils.ConfigUtils;

public class Application {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque", ConfigUtils.getPassword());
		EntityManager em = entityManagerFactory.createEntityManager();
		
	}

}
