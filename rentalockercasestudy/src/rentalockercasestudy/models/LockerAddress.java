package rentalockercasestudy.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
@Entity
@Table(name = "Locations")
public class LockerAddress {
	

	@Id
	private int addressId;
	
//	@OneToMany
//	private ArrayList<Locker> lockers;
	
	private String fullAddress;
	
	
	public LockerAddress(int addressId, String fullAddress) {
		this.addressId = addressId;
		this.fullAddress = fullAddress;
	}


	public LockerAddress() {
		super();
	}


	public int getAd() {
		return addressId;
	}


	public void setLockerNumber(int addressId) {
		this.addressId = addressId;
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
		if (addressId != other.addressId) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "LockerAddress [AddressId=" + addressId + ", fullAddress=" + fullAddress + "]";
	}
	
	
}
