
package com.example.petShop1.shopping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="dog")
public class Dog {
	@Id
	@SequenceGenerator(name = "dog_seq", sequenceName = "dog_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dog_seq")
	@Column(name = "dogid")
	private int dogid;
	
	@Column(name="Photo")
	private String Photo;
	
	@Column(name="dogBreed")
	private String dogBreed;
	
	@Column(name="age")
	private String age;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name="inoculation")
	private String inoculation;
}
