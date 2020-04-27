package com.rentalockercasestudy.sandbox;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rentalockercasestudy.dao.LockerAddressDao;
import com.rentalockercasestudy.models.LockerAddress;
import com.rentalockercasestudy.models.User;
import com.rentalockercasestudy.services.LockerAddressServices;
import com.rentalockercasestudy.services.UserServices;
import java.util.ArrayList;
public class MainRunner {
	//"tencode1"
	final static String persistenceUnitName = "com.rentalockercasestudy";
	public static void main(String[] args) {
		LockerAddressServices las = new LockerAddressServices();
		UserServices us = new UserServices();
		
			testConnection();
		//System.out.println(las.testAddLockerAddress(new LockerAddress("LincolnCenter", "1972 Broadway New York, NY 10023")));
		//System.out.println(las.testgetAllLockerAddresses());
		//System.out.println(us.testAddUserService(new User("Tracey", "encode", "tencode@hotmail.com", "tencode1")));
		//System.out.println(us.testFindUserService(new User("Tsaad@hotmail.com", "tsaad1", "Tracey", "Saad")));
		//System.out.println(us.testFindUserByEmailService("tracey_thomas@live.com"));
//		System.out.println(us.testAddUserService(new User("Shane","Lane","slane@gmail.com","slane1")));
//		System.out.println(us.testAddUserService(new User("Marcy","Peters","mpeters@yahoo.com","mpeters1")));
//		System.out.println(us.testAddUserService(new User("Tracey","IsHappy","Tishappy@hotmail.com","tishappy1")));
//		System.out.println(us.testAddUserService(new User("Icaan","Dotis","idotis@hotmail.com","idotis1")));
//		System.out.println(us.testAddUserService(new User("Imma","Survivor","isurvivor@live.com","isurvivor1")));
//		System.out.println(us.testAddUserService(new User("Corona","Quit","coranaq@yahoo.com","coronaq1")));
//		System.out.println(us.testAddUserService(new User("King","Tigers","ktigers@yahoo.com","ktigers1")));
//		System.out.println(us.testAddUserService(new User("Daisy","Rogers","drogers@gmail.com","drogers1")));
//		System.out.println(us.testAddUserService(new User("Patricia","Sampson","psampson@live.com","psampson1")));
//		System.out.println(us.testAddUserService(new User("Aden","Brady","aBrady@hotmail.com","abrady1")));
//	
		//System.out.println(us.testGetUserByUsernameAndPasswordService(new User("Shane","Lane","slane@gmail.com", "slane1")));
	}
	

	public static void  testConnection() {
		EntityManagerFactory	emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();	


		em.close();
		emf.close();
	}


}