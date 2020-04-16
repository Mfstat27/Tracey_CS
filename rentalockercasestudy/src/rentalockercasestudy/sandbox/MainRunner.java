package rentalockercasestudy.sandbox;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainRunner {

	final static String persistenceUnitName = "rentalockercasestudy";
	public static void main(String[] args) {
		
	EntityManagerFactory	emf = Persistence.createEntityManagerFactory(persistenceUnitName);
	EntityManager em = emf.createEntityManager();	
		
	
	em.close();
	emf.close();
	}


}
