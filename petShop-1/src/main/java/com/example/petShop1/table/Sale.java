
package com.example.petShop1.table;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.petShop1.shopping.Basket;
import com.example.petShop1.shopping.Dog;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="sale")
public class Sale implements Serializable {
	@Id
	@SequenceGenerator(name = "sale_seq", sequenceName = "sale_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_seq")
	@Column(name = "salid")
	private int salid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "dog")
	private String dog;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "num")
	private int num;
	
	@Column(name = "total")
	private int total;
	
	@Column(name = "address")
	private String address;
	
	@Column(name="dat")
	private LocalDateTime dat;
}

