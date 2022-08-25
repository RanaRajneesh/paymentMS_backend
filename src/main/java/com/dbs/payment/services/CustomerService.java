package com.dbs.payment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.payment.models.Customer;
import com.dbs.payment.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepo;
    
    public void addAccount(Customer customer) {
    	customerRepo.save(customer);
    }

    public List<Customer> getAllCustomerAccounts(){
        return customerRepo.findAll();
    }

}
