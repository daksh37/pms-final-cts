package com.cts.policyManagmentSystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class BankDetail {

	
	private int SR_No;
	
	@Column(nullable=false)
	private String userId;
	
	@Column(nullable=false)
	private String userName;
	
	@Column(nullable=false)
	private String paymentMode;
	
	@Column(nullable=true)
	private String cardNo;
	
	@Column(nullable=false)
	private String cvv;
	
	@Column(nullable=false)
	private String expiry;
	
	
	@Column(nullable=false)
	private String password;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	public int getSR_No() {
		return SR_No;
	}

	public void setSR_No(int sR_No) {
		SR_No = sR_No;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	@Override
	public String toString() {
		return "BankDetail [SR_No=" + SR_No + ", userId=" + userId + ", userName=" + userName + ", paymentMode="
				+ paymentMode + ", cardNo=" + cardNo + ", cvv=" + cvv + ", expiry=" + expiry + ", password=" + password
				+ "]";
	}

	
	
	
	
}
