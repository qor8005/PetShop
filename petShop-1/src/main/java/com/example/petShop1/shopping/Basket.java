
package com.example.petShop1.shopping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.petShop1.table.Customer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="basket")
public class Basket implements Serializable {
	@Id
	@SequenceGenerator(sequenceName = "basket_seq", name = "basket_seq",  initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "basket_seq")
	@Column(name = "shoid")
	private int shoid;
	
	@Column(name = "num", nullable = false)
	private int num;
	
	@ManyToOne
	@JoinColumn(name = "userNo")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "dogId")
	private Dog dog;
}
