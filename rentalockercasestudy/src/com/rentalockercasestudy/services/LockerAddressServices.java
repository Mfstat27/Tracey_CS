package com.rentalockercasestudy.services;

import java.util.ArrayList;

import com.rentalockercasestudy.dao.LockerAddressDao;
import com.rentalockercasestudy.models.LockerAddress;

public class LockerAddressServices {

	public int testAddLockerAddress(LockerAddress lockerAddress) {
		LockerAddressDao lad = new LockerAddressDao();
		int result = lad.addLockerAddress(lockerAddress); 
		System.out.println("Locker Address added");
		return result;
	}
	
	public ArrayList<LockerAddress> testgetAllLockerAddresses(){
		LockerAddressDao lad = new LockerAddressDao();
		ArrayList<LockerAddress> lockerAddresses = null;
		try {
			lockerAddresses = lad.getAllLockerAddresses();
		return	 lockerAddresses;
		}catch(NullPointerException n) {
			System.out.println("no address");
		}
		return null;
		
}

}
