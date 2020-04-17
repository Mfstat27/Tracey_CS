package com.rentalockercasestudy.dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rentalockercasestudy.models.User;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.spec.*;
import javax.crypto.*;
public class UserDao implements UserDaoI {
	final static String persistenceUnitName = "com.rentalockercasestudy";
	
	
	@Override
	public int addUser(User newUser) throws NoSuchAlgorithmException, InvalidKeySpecException {
		int result = 0;
//		SecureRandom random = new SecureRandom();
//		byte[] salt = new byte[16];
//		random.nextBytes(salt);
//		
//		PBEKeySpec spec = new PBEKeySpec(newUser.getPassword().toCharArray(), salt, 65536, 128);
//		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSha1");
//		byte[] hash = factory.generateSecret(spec).getEncoded();
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();	
		
		em.getTransaction().begin();
		em.persist(newUser);
		em.getTransaction().commit();
		result = 1;
		}catch(NullPointerException e) {
			result = 0;
		}finally {
		em.close();
		emf.close();
		}
		return result;
	}

	@Override
	public User deleteUserAccount(User inputUser) {
		User user = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			em = emf.createEntityManager();	

			em.getTransaction().begin();

			user = em.find(User.class, 1);//replace with query!
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

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findUser(User inputUser) {
		User foundUser = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();	
		
		Query query = em.createQuery("select u from User u where u.userNameEmail like :givenUserEmail");
		query.setParameter("givenUserEmail", inputUser.getUserNameEmail());
		foundUser = (User) query.getSingleResult();
		
		}catch(Exception e) {
			foundUser = null;
		}finally {
		em.close();
		emf.close();
		}
		return foundUser;
	}		
}


