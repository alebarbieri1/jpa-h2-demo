package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Account;
import com.example.demo.domain.Customer;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;

@RestController
public class DemoController {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AccountRepository accountRepository;

	@PostMapping("/customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		customer.setId(null);
		Customer customerCreated = customerRepository.save(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(customerCreated);
	}

	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> findCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return ResponseEntity.ok(customers);
	}

	@GetMapping("/account")
	public ResponseEntity<List<Account>> findAccounts() {
		List<Account> accounts = accountRepository.findAll();
		return ResponseEntity.ok(accounts);
	}

	@PostMapping("/account")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account accountCreated = accountRepository.save(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(accountCreated);
	}
}
