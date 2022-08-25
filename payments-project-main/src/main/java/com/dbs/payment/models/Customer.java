package com.dbs.payment.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private String accountNumber;
	private String name;
	private double clearBalance;
	private boolean overdraft;
	
	public Customer() {

	}
	public Customer(String accountNumber, String name, double clearBalance, boolean overdraft) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.clearBalance = clearBalance;
		this.overdraft = overdraft;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getClearBalance() {
		return clearBalance;
	}
	public void setClearBalance(double clearBalance) {
		this.clearBalance = clearBalance;
	}
	public boolean isOverdraft() {
		return overdraft;
	}
	public void setOverdraft(boolean overdraft) {
		this.overdraft = overdraft;
	}
	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", name=" + name + ", clearBalance=" + clearBalance
				+ ", overdraft=" + overdraft + "]";
	}
	
}
