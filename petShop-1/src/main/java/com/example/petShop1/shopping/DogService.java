package com.example.petShop1.shopping;

import java.util.List;


public interface DogService {
	public Dog read(int dogid) throws Exception;
	
	public List<Dog> list() throws Exception;

}
