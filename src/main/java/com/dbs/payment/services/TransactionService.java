package com.dbs.payment.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.dbs.payment.controller.TransactionRequest;
import com.dbs.payment.models.BankBIC;
import com.dbs.payment.models.Customer;
import com.dbs.payment.models.MessageCode;
import com.dbs.payment.models.TransactionHistory;
import com.dbs.payment.repository.BankRepository;
import com.dbs.payment.repository.CustomerRepository;
import com.dbs.payment.repository.MessageCodeRepository;
import com.dbs.payment.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
    CustomerRepository customerRepository;
	@Autowired
    BankRepository bankRepository;
	@Autowired
    MessageCodeRepository messageCodeRepository;
	@Autowired
    TransactionRepository transactionRepository;

    public Customer getCustomerById(String cid) {
    	
    	Optional<Customer> result = customerRepository.findById(cid);
    	if(result != null) return result.get();
    	return null;
    }
    
    public BankBIC getBankByBIC(String bic) {
    	
        Optional<BankBIC> result = bankRepository.findById(bic);
        if(result!=null) return result.get();
        return null;
    }
    
	public ResponseEntity<Object> createTransaction(TransactionRequest request) {
		
		Optional<Customer> custRes = customerRepository.findById(request.getSenderAccountNumber());
		if(custRes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("{\"msg\":\"Invalid Sender Account Number.\"}");
		}
		Customer customer = custRes.get();
		
		Optional<BankBIC> bankRes = bankRepository.findById(request.getBic());
		if(bankRes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("{\"msg\":\"Invalid BIC ID.\"}");
		}
		
		Optional<MessageCode> mesRes = messageCodeRepository.findById(request.getMessageCode().toUpperCase());
		if (mesRes.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("{\"msg\":\"Invalid Message Code.\"}");
		}
		if(!request.getTransferType().toLowerCase().contains("bank") && !request.getTransferType().toLowerCase().contains("customer")) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("{\"msg\":\"Invalid Transfer Type.\"}");
		}
		
		Double transferFee = 0.0025 * request.getAmount();
        Double totalAmount = request.getAmount() + transferFee;
        if(customer.getClearBalance()<totalAmount && !customer.isOverdraft()) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("{\"msg\":\"Not an O/D Account : Insufficient funds.\"}");
        }
        
        if (customer.getName().toUpperCase().contains("HDFC BANK")) {
        	if(!request.getTransferType().toLowerCase().contains("bank")) {
        		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("{\"msg\":\"Supports only Bank to Bank Transfer. Please select TransferType as 'Bank Transfer'.\"}");
        	}
        }
        
        try {
            File f1 = ResourceUtils.getFile("classpath:sdnlist.txt");
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            String s;
            boolean found = false;
            while((s=br.readLine())!=null)   //Reading Content from the file
            {
                if(s.toLowerCase().contains(request.getReceiverAccountName().toLowerCase())) {
                    found = true;
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("{\"msg\":\"Santioned Entity: Invalid Receiver Account Name. \"}");
                }
            }
            br.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
    	double bal = customer.getClearBalance();
    	bal = bal<totalAmount ? 0 : bal-totalAmount;
    	customer.setClearBalance(bal);
    	customerRepository.save(customer);
    	
    	Date d=new Date();
    	int day =  d.getDay();
    	System.out.println("day of the week is : "+d.getDay());
    	if(day == 0 || day == 6) {
    		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("{\"msg\":\" Can not do transactions on Saturdays and Sundays! \"}");
    	}
    	
    	
    	TransactionHistory transactionItem = new TransactionHistory(
    			request.getTransferType(),
    			request.getMessageCode(),
    			request.getAmount(),
    			request.getSenderAccountNumber(),
    			request.getBic(),
    			request.getReceiverAccountNumber(),
    			request.getReceiverAccountName(),
    			transferFee);
    	transactionRepository.save(transactionItem);
    	return ResponseEntity.status(HttpStatus.OK).body("{\"msg\":\" Transaction Successfull :) \"}");
	}
	
	public ResponseEntity<Object> getTransaction(long id) {
		Optional<TransactionHistory> res = transactionRepository.findById(id);
		if(res.isEmpty())
		return null;
		return ResponseEntity.status(HttpStatus.OK).body(res.get());
	}
	
	public ResponseEntity<Object> getTimestamp(long id) {
		Optional<TransactionHistory> res = transactionRepository.findById(id);
		if(res.isEmpty())
		return null;
		return ResponseEntity.status(HttpStatus.OK).body(res.get());
	}
 
	public ResponseEntity<Object> getAllTransactions() {
		List<TransactionHistory> res = transactionRepository.findAll();
		if(res.isEmpty())
		return null;
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

}
