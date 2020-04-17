package com.rentalockercasestudy.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.ArrayList;
@Entity
@Table(name = "Locations")
public class LockerAddress {

	@Id
	@GeneratedValue(generator="InvSeq")
	@SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=5)
	private int addressId;

	private String addressName;

	private String fullAddress;

	public LockerAddress() {
		super();
	}

	public LockerAddress(String addressName, String fullAddress) {
		this.addressName = addressName;
		this.fullAddress = fullAddress;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressId;
		result = prime * result + ((addressName == null) ? 0 : addressName.hashCode());
		result = prime * result + ((fullAddress == null) ? 0 : fullAddress.hashCode());
		return result;
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
		if (addressId != other.addressId) {
			return false;
		}
		if (addressName == null) {
			if (other.addressName != null) {
				return false;
			}
		} else if (!addressName.equals(other.addressName)) {
			return false;
		}
		if (fullAddress == null) {
			if (other.fullAddress != null) {
				return false;
			}
		} else if (!fullAddress.equals(other.fullAddress)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "LockerAddress [addressId=" + addressId + ", addressName=" + addressName + ", fullAddress=" + fullAddress
				+ "]";
	}



}
