package com.dbs.payment.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class TransactionHistory {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   	private String transferType;
   	private String messageCode;
   	private double amount;
   	private String senderAccountNumber;
   	private String bic;
   	private String receiverAccountNumber;
    private String receiverAccountName;
   	private double transferFee;
   	@CreationTimestamp	
   	private Date timestamp;
    	
	public TransactionHistory() {
		super();
	}

	public TransactionHistory(String transferType, String messageCode, double amount, String senderAccountNumber, String bic,
				String receiverAccountNumber, String receiverAccountName, double transferFee) {
			super();
			this.transferType = transferType;
			this.messageCode = messageCode;
			this.amount = amount;
			this.senderAccountNumber = senderAccountNumber;
			this.bic = bic;
			this.receiverAccountNumber = receiverAccountNumber;
			this.receiverAccountName = receiverAccountName;
			this.transferFee = transferFee;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTransferType() {
			return transferType;
	}
	public void setTransferType(String transferType) {
			this.transferType = transferType;
	}
	public String getMessageCode() {
			return messageCode;
	}
	public void setMessageCode(String messageCode) {
			this.messageCode = messageCode;
	}
	public double getAmount() {
		return amount;
	}

	public String getSenderAccountNumber() {
			return senderAccountNumber;
	}

	public void setSenderAccountNumber(String senderAccountNumber) {
			this.senderAccountNumber = senderAccountNumber;
	}

	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;	
	}
	public String getReceiverAccountNumber() {
		return receiverAccountNumber;
	}
	public void setReceiverAccountNumber(String receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}
	public String getReceiverAccountName() {
		return receiverAccountName;
	}
	public void setReceiverAccountName(String receiverAccountName) {
		this.receiverAccountName = receiverAccountName;
	}
	public double getTransferFee() {
		return transferFee;
	}

	public void setTransferFee(double transferFee) {
		this.transferFee = transferFee;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTimestamp() {
		return timestamp;
	}
		
	@Override
	public String toString() {
			return "TransactionItem [id=" + id + ", transferType=" + transferType + ", messageCode=" + messageCode
					+ ", amount=" + amount + ", senderAccountNumber=" + senderAccountNumber + ", bic=" + bic
					+ ", receiverAccountNumber=" + receiverAccountNumber + ", receiverAccountName="
					+ receiverAccountName + ", transferFee=" + transferFee + "]";
	}
    	
}
