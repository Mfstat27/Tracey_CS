package rentalockercasestudy.models;

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
	private Locker lockernumber;
	@ManyToOne
	@JoinColumn(name="CustomerID")
	private User customer;
	private String rentalDate;
	public CustomerRental() {
		super();
	}
	public CustomerRental(User customer, Locker lockernumber, String rentalDate) {
		super();
		this.customer = customer;
		this.rentalDate = rentalDate;
	}
	public Locker getLockernumber() {
		return lockernumber;
	}
	public void setLockernumber(Locker lockernumber) {
		this.lockernumber = lockernumber;
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
	
	
}

