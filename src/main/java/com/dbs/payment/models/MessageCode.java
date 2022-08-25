package com.dbs.payment.models;

import javax.persistence.Entity;

import javax.persistence.Id;
@Entity
public class MessageCode {
	
    @Id
    String messageCode;
    String description;

	public MessageCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessageCode(String messageCode, String description) {
		super();
		this.messageCode = messageCode;
		this.description = description;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
}