package rentalockercasestudy.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table

public class Locker {
@Id
@Column
private int lockerId;
UUID lockerKey;
private int lockerNumber;


private LockerAddress lockerLocation;

	public Locker() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
