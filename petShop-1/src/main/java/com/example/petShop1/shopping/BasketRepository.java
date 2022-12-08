
package com.example.petShop1.shopping;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.petShop1.table.Customer;

public interface BasketRepository extends JpaRepository<Basket,Integer> {
	List<Basket> findByCustomer(Customer cu);
}
