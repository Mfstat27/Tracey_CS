package rentalockercasestudy.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table

public class Locker {
@Id
@GeneratedValue(generator="InvSeq")
@SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=5)
private int lockerId;

@Transient
private UUID lockerKey;//this needs to change for each customer. A new instance for each customer? but I don't want the lockerId to change just the locker key
//private int lockerNumber;

@ManyToOne
private LockerAddress lockerLocation;

@ManyToOne
private User user;

	public Locker() {
		super();
		
	}
	
	public Locker(LockerAddress lockerLocation) {
		super();
		//this.lockerNumber = lockerNumber;
		this.lockerLocation = lockerLocation;
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
		Locker other = (Locker) obj;
		if (lockerId != other.lockerId) {
			return false;
		}
		if (lockerKey == null) {
			if (other.lockerKey != null) {
				return false;
			}
		} else if (!lockerKey.equals(other.lockerKey)) {
			return false;
		}
		if (lockerLocation == null) {
			if (other.lockerLocation != null) {
				return false;
			}
		} else if (!lockerLocation.equals(other.lockerLocation)) {
			return false;
		}
//		if (lockerNumber != other.lockerNumber) {
//			return false;
//		}
		return true;
	}

	public int getLockerId() {
		return lockerId;
	}

	public void setLockerId(int lockerId) {
		this.lockerId = lockerId;
	}

	public UUID getLockerKey() {
		return lockerKey;
	}

	public void setLockerKey(UUID lockerKey) {
		this.lockerKey = lockerKey;
	}

//	public int getLockerNumber() {
//		return lockerNumber;
//	}
//
//	public void setLockerNumber(int lockerNumber) {
//		this.lockerNumber = lockerNumber;
//	}

	public LockerAddress getLockerLocation() {
		return lockerLocation;
	}

	public void setLockerLocation(LockerAddress lockerLocation) {
		this.lockerLocation = lockerLocation;
	}

	@Override
	public String toString() {
		return "Locker [lockerId=" + lockerId
				+ ", lockerLocation=" + lockerLocation + "]";
	}

}
