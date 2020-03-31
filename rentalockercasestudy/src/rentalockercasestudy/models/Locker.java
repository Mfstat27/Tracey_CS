package rentalockercasestudy.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Locker {
@Id
@Column
private int lockerId;
	public Locker() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
