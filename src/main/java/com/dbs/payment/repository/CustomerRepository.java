package com.dbs.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.payment.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
