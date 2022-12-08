
package com.example.petShop1.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
@Table(name="customer")
public class Customer {
	@Id
	@SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
	private Integer userNo;
	
	
	@Column(name="id", nullable = false)
	private String id;
	
	
	@Column(name="password", nullable = false)
	private String password;
	
	
	@Column(name="name", nullable = false)
	private String name;
	
	
	@Column(name="birth")
	private String birth;
	
	
	@Column(name="gender")
	private String gender;
	
	
	@Column(name="email", nullable = false)
	private String email;
	
	
	@Column(name="pon", nullable = false)
	private String pon;
}
