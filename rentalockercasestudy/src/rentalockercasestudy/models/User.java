package rentalockercasestudy.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.stripe.Stripe;
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
	
	@ManyToOne
	private Payment payment;
	
	@ManyToOne
	private Locker locker;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public User(String userNameEmail, String password, String firstName, String lastName, 
			Locker locker) {
		this.userNameEmail = userNameEmail;
		Password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.locker = locker;
	}



	public String getUserNameEmail() {
		return userNameEmail;
	}

	public void setUserNameEmail(String userNameEmail) {
		this.userNameEmail = userNameEmail;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Locker getLocker() {
		return locker;
	}

	public void setLocker(Locker locker) {
		this.locker = locker;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (locker == null) {
			if (other.locker != null)
				return false;
		} else if (!locker.equals(other.locker))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (userNameEmail == null) {
			if (other.userNameEmail != null)
				return false;
		} else if (!userNameEmail.equals(other.userNameEmail))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "User [userNameEmail=" + userNameEmail + ", Password=" + Password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", payment=" + payment + ", locker=" + locker + "]";
	}


	
	

}
