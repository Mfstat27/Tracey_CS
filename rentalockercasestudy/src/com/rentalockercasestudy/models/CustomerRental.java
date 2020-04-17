package com.rentalockercasestudy.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;
//This class creates a table showing each customers rental history
@Entity
@Table(name="RentalHistory")
public class CustomerRental {
	
	@Id
	@GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=5)
	private int rentalNumber;
	
	@ManyToOne
	@JoinColumn(name = "LockerID")
	private Locker lockerNumber;
	@ManyToOne
	@JoinColumn(name="CustomerID")
	private User customer;
	private String rentalDate;
	
	public CustomerRental() {
		super();
	}
	public CustomerRental(User customer, Locker lockerNumber, String rentalDate) {
		super();
		this.customer = customer;
		this.lockerNumber = lockerNumber;
		this.rentalDate = rentalDate;
	}
	public Locker getLockerNumber() {
		return lockerNumber;
	}
	public void setLockernumber(Locker lockerNumber) {
		this.lockerNumber = lockerNumber;
	}
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	public String getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}
	@Override
	public String toString() {
		return "CustomerRental [rentalNumber=" + rentalNumber + ", lockerNumber=" + lockerNumber + ", customer="
				+ customer + ", rentalDate=" + rentalDate + "]";
	}
	
	
}

