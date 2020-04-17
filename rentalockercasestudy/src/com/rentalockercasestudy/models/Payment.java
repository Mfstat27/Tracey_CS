package com.rentalockercasestudy.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Payment {
	@Id
	@GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=5)
	private int paymentId;
	private long accountNum;
	private int expDate;
	private int securityCode;
	private String nameOnCard;
	private String paymentName;
	
	@ManyToOne
	private User user;
	
	public Payment() {
		super();
	}
	public Payment(long accountNum, int expDate, int securityCode, String nameOnCard, String paymentName,User user) {
		this.accountNum = accountNum;
		this.expDate = expDate;
		this.securityCode = securityCode;
		this.nameOnCard = nameOnCard;
		this.paymentName = paymentName;
		this.user = user;
	}
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(long accountNum) {
		this.accountNum = accountNum;
	}
	public int getExpDate() {
		return expDate;
	}
	public void setExpDate(int expDate) {
		this.expDate = expDate;
	}
	
	public int getsId() {
		return securityCode;
	}
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
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
		return "Payment [pNum=" + accountNum + ", expDate=" + expDate + ", pId=" + securityCode + ", nameOnCard=" + nameOnCard
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
		if (securityCode != other.securityCode)
			return false;
		if (accountNum != other.accountNum)
			return false;
		if (paymentName == null) {
			if (other.paymentName != null)
				return false;
		} else if (!paymentName.equals(other.paymentName))
			return false;
		return true;
	}

	
	
}
