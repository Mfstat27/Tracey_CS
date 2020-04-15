package rentalockercasestudy.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Locations")
public class LockerAddress {
	

	@Id
	private int lockerNumber;
	
	private String fullAddress;
	
	
	public LockerAddress(int lockerNumber, String fullAddress) {
		this.lockerNumber = lockerNumber;
		this.fullAddress = fullAddress;
	}


	public LockerAddress() {
		super();
	}


	public int getLockerNumber() {
		return lockerNumber;
	}


	public void setLockerNumber(int lockerNumber) {
		this.lockerNumber = lockerNumber;
	}


	public String getFullAddress() {
		return fullAddress;
	}


	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		LockerAddress other = (LockerAddress) obj;
		if (fullAddress == null) {
			if (other.fullAddress != null) {
				return false;
			}
		} else if (!fullAddress.equals(other.fullAddress)) {
			return false;
		}
		if (lockerNumber != other.lockerNumber) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "LockerAddress [lockerNumber=" + lockerNumber + ", fullAddress=" + fullAddress + "]";
	}
	
	
}
