package com.example.petShop1.shopping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Cart implements Serializable {
	//private final DogRepository dogRepository;
	
	private static final long serVersionUID = 5189420799881063838L;
	private List<DogSet>dogSetList = new ArrayList<DogSet>();
		
	public List<DogSet>getDogSetList(){
		return this.dogSetList;
	}
	
	public boolean isEmpty() {
		if(this.dogSetList == null || this.dogSetList.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public void push(DogSet pushedDogSet) {
		//추가 상품이 카트에 이미 존재하는지 확인하는 플래그
		boolean dogExistlnCart = false;
		
		//추가된 상품의 상품ID를 획득
		Dog pushedDog = pushedDogSet.getDog();
		int pushedDogid = pushedDog.getDogid();
		
		//카트의 상품 수만큼 반복 실행
		for(DogSet cartDogSet: this.dogSetList) {
			
			//카트에 있는 상품의 ID를 획득
			Dog cartDog = cartDogSet.getDog();
			int cartDogid = cartDog.getDogid();
			
			if(cartDogid == pushedDogid) {
				
				//동일 ID의 상품이 카트에 존재하는 경우, 수량만 가산
				cartDogSet.addQuqntity(pushedDogSet.getQuantity());
				
				//추가상품이 카트안에 이미 존재함
				dogExistlnCart = true;
				break;
			}
		}
		
		if(!dogExistlnCart) {
			//카트에 동일 상품이 없으므로 추가
			this.dogSetList.add(pushedDogSet);
		}
	}
	
	public void clearAll() {
		this.dogSetList = new ArrayList<DogSet>();
	}
}

