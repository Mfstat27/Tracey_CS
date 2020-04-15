package rentalockercasestudy.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.stripe.Stripe;
import com.stripe.model.PaymentMethod;
import java.util.ArrayList;
@Entity
@Table
public class User {
	@Id
	private int customerId;
	@NonNull
	
	private String userNameEmail;
	private String Password;
	private String firstName;
	private String lastName;
	private Payment payment;
	
	@OneToMany
	private ArrayList<Payment> payments;
	
	@ManyToOne
	@JoinColumn(name="LockerID")
	private Locker lockerNumber;

	public User() {
		super();
	}
	
	public User(String userNameEmail, String password, String firstName, String lastName) {
		this.userNameEmail = userNameEmail;
		Password = password;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public Locker getLockerNumber() {
		return lockerNumber;
	}

	public void setLocker(Locker lockerNumber) {
		this.lockerNumber = lockerNumber;
	}

	public ArrayList<Payment> getPayments() {
		return payments;
	}

	public void setPayments(ArrayList<Payment> payments) {
		this.payments = payments;
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
		User other = (User) obj;
		if (Password == null) {
			if (other.Password != null) {
				return false;
			}
		} else if (!Password.equals(other.Password)) {
			return false;
		}
		if (customerId != other.customerId) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (lockerNumber == null) {
			if (other.lockerNumber != null) {
				return false;
			}
		} else if (!lockerNumber.equals(other.lockerNumber)) {
			return false;
		}
		if (payment == null) {
			if (other.payment != null) {
				return false;
			}
		} else if (!payment.equals(other.payment)) {
			return false;
		}
		if (payments == null) {
			if (other.payments != null) {
				return false;
			}
		} else if (!payments.equals(other.payments)) {
			return false;
		}
		if (userNameEmail == null) {
			if (other.userNameEmail != null) {
				return false;
			}
		} else if (!userNameEmail.equals(other.userNameEmail)) {
			return false;
		}
		return true;
	}



	@Override
	public String toString() {
		return "User [userNameEmail=" + userNameEmail + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
