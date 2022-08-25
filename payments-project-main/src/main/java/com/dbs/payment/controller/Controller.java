package com.dbs.payment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.payment.models.BankBIC;
import com.dbs.payment.models.Customer;
import com.dbs.payment.models.TransactionHistory;
import com.dbs.payment.services.CustomerService;
import com.dbs.payment.services.TransactionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Controller {

	@Autowired
	TransactionService transactionService;
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/home")
	@ResponseBody
	public String getHome() {
    	System.out.println("Fetching customer....");
		return "Vineeth here!";
	}

	//Add a new customer
	@PostMapping("/addcustomer")
    public void addAccount(@RequestBody Customer customer) {
		System.out.println(customer.toString());
        customerService.addAccount(customer);
    }
	
	//Fetch all the customers 
    @GetMapping("/allCustomerAccounts")
    public List<Customer> getAllBankAccounts(){
        return customerService.getAllCustomerAccounts();
    }
	
    //Getting customer details by ID
    @GetMapping("customer/{cid}")
    public Customer getCustomerById(@PathVariable String cid) {
    	System.out.println("Fetching customer....");
        Customer customer = transactionService.getCustomerById(cid);
        System.out.println(customer);
        return customer;
    }
    
    //Getting bank details by BIC
    @GetMapping("bank/{bic}")
    public BankBIC getBankByBIC(@PathVariable String bic) {
        BankBIC bank = transactionService.getBankByBIC(bic);
        return bank;
    }

    //Adding a new transaction
    @PostMapping("transaction")
    public ResponseEntity<Object> makeTransaction(@RequestBody TransactionRequest request) {
    	 System.out.println(request.toString());
        return transactionService.createTransaction(request);
    }
    
    
    
    //Getting transaction details by ID.
    @GetMapping("getTrans/{id}")
    public ResponseEntity<Object> getTrans(@PathVariable long id) {
//   	 System.out.println(request.toString());
       return transactionService.getTransaction(id);
    }
    
  //Fetch all the customers 
    @GetMapping("/transactions")
    public ResponseEntity<Object> getTransactions(){
        return transactionService.getAllTransactions();
    }

}
