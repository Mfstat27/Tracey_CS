package rentalockercasestudy.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Payment {
	@Id
	@GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=5)
	private int pId;
	private long pNum;
	private int expDate;
	private int sId;
	private String nameOnCard;
	private String paymentName;
	
	public Payment() {
		super();
	}
	public Payment(long pNum, int expDate, int sId, String nameOnCard, String paymentName) {
		this.pNum = pNum;
		this.expDate = expDate;
		this.sId = sId;
		this.nameOnCard = nameOnCard;
		this.paymentName = paymentName;
	}
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public long getpNum() {
		return pNum;
	}
	public void setpNum(long pNum) {
		this.pNum = pNum;
	}
	public int getExpDate() {
		return expDate;
	}
	public void setExpDate(int expDate) {
		this.expDate = expDate;
	}
	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getPaymentName() {
		return paymentName;
	}
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	@Override
	public String toString() {
		return "Payment [pNum=" + pNum + ", expDate=" + expDate + ", pId=" + sId + ", nameOnCard=" + nameOnCard
				+ ", paymentName=" + paymentName + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (expDate != other.expDate)
			return false;
		if (nameOnCard == null) {
			if (other.nameOnCard != null)
				return false;
		} else if (!nameOnCard.equals(other.nameOnCard))
			return false;
		if (sId != other.sId)
			return false;
		if (pNum != other.pNum)
			return false;
		if (paymentName == null) {
			if (other.paymentName != null)
				return false;
		} else if (!paymentName.equals(other.paymentName))
			return false;
		return true;
	}

	
	
}
