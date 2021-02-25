package fr.diginamic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.entites.Adresse;
import fr.diginamic.entites.Banque;
import fr.diginamic.entites.Client;
import fr.diginamic.entites.Compte;
import fr.diginamic.entites.LivretA;
import fr.diginamic.entites.Operation;
import fr.diginamic.entites.Virement;
import fr.diginamic.utils.ConfigUtils;

public class Application {

	public static void main(String[] args) {
		Banque banque1 = new Banque("Caisse d'épargne");
		Banque banque2 = new Banque("LCL");

		Adresse adresse1 = new Adresse(25, "rue de la mairie", "35000", "Rennes");
		Adresse adresse2 = new Adresse(12, "rue de la banque", "44000", "Nantes");
		Adresse adresse3 = new Adresse(236, "rue principale", "75000", "Paris");

		Client client1 = new Client("Potter", "Harry", LocalDate.of(1992, Month.JANUARY, 12), adresse1);
		Client client2 = new Client("Granger", "Hermione", LocalDate.of(1991, Month.FEBRUARY, 2), adresse2);
		Client client3 = new Client("Malfoy", "Drago", LocalDate.of(1989, Month.DECEMBER, 23));
		Client client4 = new Client("Neuvile", "Londubas", LocalDate.of(1990, Month.NOVEMBER, 25));

		Compte compte1 = new Compte("024108402", 256.53);
		Compte compte2 = new Compte("817811817", 1_871.3);
		Compte compte3 = new Compte("083417543", 6.5);
		Compte compte4 = new Compte("864818645", -32.0);
		List<Compte> comptes1 = new ArrayList<Compte>();
		comptes1.add(compte1);
		comptes1.add(compte2);
		comptes1.add(compte3);
		List<Compte> comptes2 = new ArrayList<Compte>();
		comptes2.add(compte4);
		LivretA livretA1 = new LivretA("083417543", 6_789.5, 2.5);

		Operation operation1 = new Operation(LocalDateTime.of(2021, 2, 12, 18, 0), 29.68, "achat baguette");
		Operation operation2 = new Operation(LocalDateTime.of(2021, 2, 12, 19, 0), 536.68, "achat potion");
		List<Operation> operations = new ArrayList<>();
		operations.add(operation1);
		operations.add(operation2);
		Virement virement1 = new Virement(LocalDateTime.of(2021, 2, 12, 19, 0), 35.98, "remboursement", "Ron");
		
		client3.setAdresse(adresse3);
		client1.setBanque(banque1);
		client2.setBanque(banque1);
		client3.setBanque(banque2);
		client4.setBanque(banque2);
		client1.setComptes(comptes1);
		client2.setComptes(comptes2);
		client3.addCompte(livretA1);
		client2.addCompte(compte2);
		client2.addCompte(compte3);

		compte1.addOperation(operation1);
		compte1.addOperation(operation2);
		compte3.addOperation(virement1);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque",
				ConfigUtils.getPassword());

		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		em.persist(banque1);
		em.persist(banque2);

		em.persist(client1);
		em.persist(client2);
		em.persist(client3);
		em.persist(client4);

		em.persist(compte1);
		em.persist(compte2);
		em.persist(compte3);
		em.persist(compte4);
		em.persist(livretA1);

		em.persist(operation1);
		em.persist(operation2);
		em.persist(virement1);

		transaction.commit();
		
		em.close();

		EntityManager em2 = entityManagerFactory.createEntityManager();

		Banque b = em2.find(Banque.class, 1);
		Banque b2 = em2.find(Banque.class, 2);
		List<Banque> banques = new ArrayList<>();
		banques.add(b);
		banques.add(b2);
		for (Banque banque : banques) {
			System.out.println(banque.getNom());
			for (Client client : banque.getClients()) {
				System.out.println(client);
				for (Compte compte : client.getComptes()) {
					System.out.println(compte);
					for (Operation operation : compte.getOperations()) {
						System.out.println(operation);
					}
				}
			}
			System.out.println("------------------------------------");
		}

		em2.close();
		
		List<Banque> banques2 = new ArrayList<>();
		banques2.add(banque1);
		banques2.add(banque2);
		for (Banque banque : banques2) {
			System.out.println(banque.getNom());
			for (Client client : banque.getClients()) {
				System.out.println(client);
				for (Compte compte : client.getComptes()) {
					System.out.println(compte);
					for (Operation operation : compte.getOperations()) {
						System.out.println(operation);
					}
				}
			}
			System.out.println("------------------------------------");
		}
		
		for (Banque banque : banques) {
			System.out.println(banque.getNom());
			for (Client client : banque.getClients()) {
				System.out.println(client);
				for (Compte compte : client.getComptes()) {
					System.out.println(compte);
					for (Operation operation : compte.getOperations()) {
						System.out.println(operation);
					}
				}
			}
			System.out.println("------------------------------------");
		}
	}

}
