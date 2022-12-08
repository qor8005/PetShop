package com.example.petShop1.table;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerService {
	private final CustomerRepository customerRepository;
	
	public List<Customer>getList() {
		return customerRepository.findAll();
	}
	
}
