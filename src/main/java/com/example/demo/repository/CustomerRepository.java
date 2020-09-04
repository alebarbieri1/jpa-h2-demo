package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
