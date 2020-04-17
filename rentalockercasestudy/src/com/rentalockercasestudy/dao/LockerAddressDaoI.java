package com.rentalockercasestudy.dao;

import java.util.ArrayList;

import com.rentalockercasestudy.models.LockerAddress;

public interface LockerAddressDaoI {
	public int addLockerAddress(LockerAddress lockerAddress);
	public boolean updateLockerAddresses(LockerAddress lockerAddress, LockerAddress newLockerAddress);
	public int removeLockerAddressesById(int AddressId);
	public ArrayList<LockerAddress> getAllLockerAddresses();
	public LockerAddress getLockerAddress(int AddressId);
}
