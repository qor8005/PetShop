package com.example.petShop1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.petShop1.table.CustomerRepository;

@SpringBootTest
class PetShop1ApplicationTests {

	@Autowired
	private CustomerRepository repository;
	

}
