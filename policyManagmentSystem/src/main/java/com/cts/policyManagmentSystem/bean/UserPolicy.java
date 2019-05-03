package com.cts.policyManagmentSystem.bean;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="UserPolicy")
@Table(name="UserPolicy")
public class UserPolicy {
	private int SR_No;
	private String userId;
	private String policyId;
	private String paymentStatus;
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
public String getPaymentStatus() {
	return paymentStatus;
}
public void setPaymentStatus(String paymentStatus) {
	this.paymentStatus = paymentStatus;
}
public String getPolicyId() {
	return policyId;
}
public void setPolicyId(String policyId) {
	this.policyId = policyId;
}

public UserPolicy() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "UserPolicy [SR_No=" + SR_No + ", userId=" + userId + ", policyId=" + policyId + ", paymentStatus="
			+ paymentStatus + "]";
}






	
	
}
