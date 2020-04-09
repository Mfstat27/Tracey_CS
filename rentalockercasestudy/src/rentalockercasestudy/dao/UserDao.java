package rentalockercasestudy.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import rentalockercasestudy.models.User;

public class UserDao implements UserDaoI {
	final static String persistenceUnitName = "rentalockercasestudy";
	
	
	@Override
	public int addUser(User newUser) {
		int result = 0;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();	
		
		em.getTransaction().begin();
		
		em.persist(newUser);
		em.getTransaction().commit();
		result = 1;
		}catch(Exception e) {
			result = 0;
		}finally {
		em.close();
		emf.close();
		}
		return result;
	}

	@Override
	public User deleteUserAccount(String userNameEmail) {
		User user = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			em = emf.createEntityManager();	

			em.getTransaction().begin();

			user = em.find(User.class, userNameEmail);
			if (user != null) {
				em.remove(user); // remove tries 2 operations first find and then remove but it is && 

				em.getTransaction().commit();
			}
		}catch(Exception e) {
			user = null;
		}finally {
			em.close();
			emf.close();
		}

		return user;
	}		
}


