package com.dbs.payment.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankBIC {
	@Id
	private String bic;
	private String name;
	
	public BankBIC() {
		super();
	}
	public BankBIC(String bic, String name) {
		super();
		this.bic = bic;
		this.name = name;
	}
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
