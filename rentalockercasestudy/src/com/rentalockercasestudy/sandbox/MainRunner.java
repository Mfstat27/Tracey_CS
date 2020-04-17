package com.rentalockercasestudy.sandbox;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rentalockercasestudy.dao.LockerAddressDao;
import com.rentalockercasestudy.models.LockerAddress;
import com.rentalockercasestudy.models.User;
import com.rentalockercasestudy.services.LockerAddressServices;
import com.rentalockercasestudy.services.UserServices;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
public class MainRunner {

	final static String persistenceUnitName = "com.rentalockercasestudy";
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		LockerAddressServices las = new LockerAddressServices();
		UserServices us = new UserServices();
		//	testConnection();
		//System.out.println(las.testAddLockerAddress(new LockerAddress("LincolnCenter", "1972 Broadway New York, NY 10023")));
		//System.out.println(las.testgetAllLockerAddresses());
		//System.out.println(us.testAddUser(new User("Tishappy@hotmail.com", "tishappy1", "Tracey", "IsHappy")));
		System.out.println(us.testFindUserService(new User("Tisnhappy@hotmail.com", "tishappy1", "Tracey", "IsHappy")));
	}

	public static void  testConnection() {
		EntityManagerFactory	emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();	


		em.close();
		emf.close();
	}


}