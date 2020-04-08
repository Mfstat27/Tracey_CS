package rentalockercasestudy.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Locations")
public class Address {
	

	@Id
	private String fullAddress;
	
	
	public Address(String fullAddress) {
		this.fullAddress = fullAddress;
	}


	public Address() {
		super();
	}

}
