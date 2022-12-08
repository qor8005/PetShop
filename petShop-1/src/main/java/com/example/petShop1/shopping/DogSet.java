package com.example.petShop1.shopping;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class DogSet implements Serializable {
	private static final long serialVersionUID = -8365095344042419340L;
	private Dog dog;
	private int quantity;
	
	public void addQuqntity(int addQuantity) {
		setQuantity(this.quantity+addQuantity);
	}
}
