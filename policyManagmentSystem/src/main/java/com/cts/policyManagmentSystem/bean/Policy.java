package com.cts.policyManagmentSystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Policy {

	@Id
	@Column(nullable=false,length=50)
	private String policyId;
	
	@Column(nullable=false,length=50)
	private String policyName;
	
	@Column(nullable=false,length=10)
	private String policyType;
	
	@Column(nullable=false,length=2)
	private String duration;
	
	@Column(length=50)
	private String company;
	
	@Column(nullable=false,length=10)
	private int initialDeposit;
	
	
	
	@Column(nullable=false,length=15)
	private int termAmount;
	
	@Column(nullable=false,length=2)
	private int interest;
	
	public Policy() {
		// TODO Auto-generated constructor stub
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getInitialDeposit() {
		return initialDeposit;
	}

	public void setInitialDeposit(int initialDeposit) {
		this.initialDeposit = initialDeposit;
	}

	

	public int getTermAmount() {
		return termAmount;
	}

	public void setTermAmount(int termAmount) {
		this.termAmount = termAmount;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", duration=" + duration + ", company=" + company + ", initialDeposit=" + initialDeposit
				+ ", termAmount=" + termAmount + ", interest=" + interest + "]";
	}

	
	
	
	
}
