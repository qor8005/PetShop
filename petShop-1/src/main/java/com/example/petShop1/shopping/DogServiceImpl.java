package com.example.petShop1.shopping;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Service
@Slf4j
public class DogServiceImpl implements DogService {
	private final DogRepository dogRepository;
	
	@Override
	public Dog read(int dogid) throws Exception{
		List<Dog>dogList = createDogList();
		
		for(Dog dog : dogList) {
			if(dog.getDogid() == dogid) {
				return dog;
			}
		}
		return null;
	}

	@Override
	public List<Dog> list() throws Exception{
		return createDogList();
	}

	public List<Dog> createDogList()  {
		List<Dog> dogList = new ArrayList<>();

		Dog newDog1 = new Dog();
		newDog1.setPhoto("http://우리펫.com/shop/data/editor/2210/8e46c0d8fbe72647862e862cc6683c1e_1665224674_9757.jpg");
		newDog1.setDogid(1);
		newDog1.setAge("2개월");
		newDog1.setDogBreed("말티즈");
		newDog1.setGender("암컷");
		newDog1.setInoculation("2차접종");
		newDog1.setPrice(1100000);
		dogList.add(newDog1);
		dogRepository.save(newDog1);
		
		
		Dog newDog2 = new Dog();
		newDog2.setPhoto("http://www.우리펫.com/shop/data/editor/1709/a0bef4827e21d67fdafea1481efae97f_1506070853_6.JPG");
		newDog2.setDogid(2);
		newDog2.setAge("2개월");
		newDog2.setDogBreed("시바이누");
		newDog2.setGender("수컷");
		newDog2.setInoculation("1차접종");
		newDog2.setPrice(300000);
		dogList.add(newDog2);
		dogRepository.save(newDog2);
		
		
		Dog newDog3 = new Dog();
		newDog3.setPhoto("http://우리펫.com/shop/data/editor/2112/7881444e0de23383088d71b458812d26_1640934779_31.jpg");
		newDog3.setDogid(3);
		newDog3.setAge("2개월");
		newDog3.setDogBreed("골든리트리버");
		newDog3.setGender("수컷");
		newDog3.setInoculation("2차접종");
		newDog3.setPrice(900000);
		dogList.add(newDog3);
		dogRepository.save(newDog3);
		
		
		Dog newDog4 = new Dog();
		newDog4.setPhoto("http://우리펫.com/shop/data/editor/2210/8e46c0d8fbe72647862e862cc6683c1e_1665219236_1693.jpg");
		newDog4.setDogid(4);
		newDog4.setAge("2개월");
		newDog4.setDogBreed("푸들");
		newDog4.setGender("수컷");
		newDog4.setInoculation("2차접종");
		newDog4.setPrice(250000);
		dogList.add(newDog4);
		dogRepository.save(newDog4);
		
		
		Dog newDog5 = new Dog();
		newDog5.setPhoto("http://우리펫.com/shop/data/editor/2112/3ea39610fb25c338e21c13065760d450_1638953890_2921.jpg");
		newDog5.setDogid(5);
		newDog5.setAge("2개월");
		newDog5.setDogBreed("시바이누");
		newDog5.setGender("수컷");
		newDog5.setInoculation("1차접종");
		newDog5.setPrice(800000);
		dogList.add(newDog5);
		dogRepository.save(newDog5);
		

		Dog newDog6 = new Dog();
		newDog6.setPhoto("http://우리펫.com/shop/data/editor/2107/99452c1e31a1fbe34b31b6b8f5c301b4_1627262563_6619.jpg");
		newDog6.setDogid(6);
		newDog6.setAge("2개월");
		newDog6.setDogBreed("보더콜리");
		newDog6.setGender("암컷");
		newDog6.setInoculation("2차접종");
		newDog6.setPrice(2700000);
		dogList.add(newDog6);
		dogRepository.save(newDog6);
		
		
		Dog newDog7 = new Dog();
		newDog7.setPhoto("http://우리펫.com/shop/data/editor/2210/d339dd07cbdbcaaf1035d8081c449532_1665135798_779.jpg");
		newDog7.setDogid(7);
		newDog7.setAge("2개월");
		newDog7.setDogBreed("포메라니안");
		newDog7.setGender("암컷");
		newDog7.setInoculation("2차접종");
		newDog7.setPrice(250000);
		dogList.add(newDog7);
		dogRepository.save(newDog7);
		
		
		Dog newDog8 = new Dog();
		newDog8.setPhoto("http://우리펫.com/shop/data/editor/2112/75101400eacebf39ccd9f57063efcdc5_1638581814_2656.jpg");
		newDog8.setDogid(8);
		newDog8.setAge("2개월");
		newDog8.setDogBreed("닥스훈트");
		newDog8.setGender("수컷");
		newDog8.setInoculation("1차접종");
		newDog8.setPrice(800000);
		dogList.add(newDog8);
		dogRepository.save(newDog8);
		
		
		Dog newDog9 = new Dog();
		newDog9.setPhoto("http://www.yomidog.com/preSaleUpFile/190417_%EC%84%B1%EB%B6%81%EC%82%AC%EB%AA%A8%EC%98%88%EB%93%9C_638.jpg");
		newDog9.setDogid(9);
		newDog9.setAge("2개월");
		newDog9.setDogBreed("사모예드");
		newDog9.setGender("수컷");
		newDog9.setInoculation("1차접종");
		newDog9.setPrice(3000000);
		dogList.add(newDog9);
		dogRepository.save(newDog9);


		return dogList;
	}

}
