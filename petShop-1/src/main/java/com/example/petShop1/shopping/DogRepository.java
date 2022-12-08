
package com.example.petShop1.shopping;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DogRepository extends JpaRepository<Dog,Integer> {
	Optional<Dog> findById(Integer dogid);
	//Optional<Dog> findByDogBreed(String dogBreed);
}
