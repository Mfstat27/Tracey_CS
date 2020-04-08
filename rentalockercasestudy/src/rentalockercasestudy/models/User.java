package rentalockercasestudy.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.stripe.model.PaymentMethod;

@Entity
@Table
public class User {
	@NonNull
	@Id
	private String userNameEmail;
	private String Password;
	private String firstName;
	private String lastName;
	private PaymentMethod payment;
	
	@ManyToOne
	private Locker locker;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

}
