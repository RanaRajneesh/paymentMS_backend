package com.dbs.payment.controller;

public class TransactionRequest {
	
	private String transferType;
	private String messageCode;
	private double amount;
	private String senderAccountNumber;
	private String bic;
	private String receiverAccountNumber;
	private String receiverAccountName;
	
	public TransactionRequest() {
		super();
	}

	public TransactionRequest(String transferType, String messageCode, int amount, String senderAccountNumber,
			String bic, String receiverAccountNumber, String receiverAccountName) {
		super();
		this.transferType = transferType;
		this.messageCode = messageCode;
		this.amount = amount;
		this.senderAccountNumber = senderAccountNumber;
		this.bic = bic;
		this.receiverAccountNumber = receiverAccountNumber;
		this.receiverAccountName = receiverAccountName;
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
	public void setAmount(int amount) {
		this.amount = amount;
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

	@Override
	public String toString() {
		return "TransactionRequest [transferType=" + transferType + ", messageCode=" + messageCode + ", amount="
				+ amount + ", senderAccountNumber=" + senderAccountNumber + ", bic=" + bic + ", receiverAccountNumber="
				+ receiverAccountNumber + ", receiverAccountName=" + receiverAccountName + "]";
	}

}
