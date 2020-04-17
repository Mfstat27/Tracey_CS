package com.rentalockercasestudy.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rentalockercasestudy.models.LockerAddress;

import java.util.List;

public class LockerAddressDao implements LockerAddressDaoI {
	final static String persistenceUnitName = "com.rentalockercasestudy";
	@Override
	public int addLockerAddress(LockerAddress lockerAddress) {
		int result = 0;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();	
		
		em.getTransaction().begin();
		
		em.persist(lockerAddress);
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
	public boolean updateLockerAddresses(LockerAddress lockerAddress, LockerAddress newLockerAddress) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int removeLockerAddressesById(int AddressId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<LockerAddress> getAllLockerAddresses() {
		List<LockerAddress> lockerAddresses = null;
		ArrayList<LockerAddress> lockerAddresses2 = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();	
		
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT l FROM LockerAddress l");
		lockerAddresses = query.getResultList();
		lockerAddresses2 = new ArrayList<LockerAddress>(lockerAddresses);
		em.getTransaction().commit();
		}catch(NullPointerException n) {
			n.getMessage();
		}finally {
		em.close();
		emf.close();
		}
			return lockerAddresses2;
	}

	@Override
	public LockerAddress getLockerAddress(int AddressId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
