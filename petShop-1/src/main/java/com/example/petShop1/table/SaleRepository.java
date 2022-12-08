
package com.example.petShop1.table;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Integer> {
	//Optional<Sale> findBySalid(int salid);
	List<Sale> findById(int id);
}
