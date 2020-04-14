package rentalockercasestudy.models;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


public class UserPaymentMethods {
	


private ArrayList<Payment> userParments;

public ArrayList<Payment> getUserParments() {
	return userParments;
}

public void setUserParments(ArrayList<Payment> userParments) {
	this.userParments = userParments;
}


}
