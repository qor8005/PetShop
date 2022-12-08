package com.example.petShop1.kakao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.petShop1.log.UserInfo;
import com.example.petShop1.shopping.Basket;
import com.example.petShop1.shopping.BasketRepository;
import com.example.petShop1.shopping.Dog;
import com.example.petShop1.table.Customer;
import com.example.petShop1.table.CustomerRepository;
import com.example.petShop1.table.Sale;
import com.example.petShop1.table.SaleRepository;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@RequiredArgsConstructor
@Log
@Controller
public class SampleController {
	private final SaleRepository saleRepository;
	private final BasketRepository basketRepository;
    private final CustomerRepository customerRepository;
    String pos;

    
    @Setter(onMethod_ = @Autowired) //자동으로 kakaopay 맞는걸로 객체생성(setter)
    private KakaoPay kakaopay;
    
    
    @GetMapping("/kakaoPay") // 페이지 들어가면 kakaoPay.html 불러옴
    public void kakaoPayGet() {
    }
    
    @PostMapping("/kakaoPay") // 페이지 들어가서 사용자가 입력한 정보를 보낸다
    public String kakaoPay(
    		@RequestParam("sample6_postcode")String sample6_postcode, @RequestParam("sample6_detailAddress")String sample6_detailAddress,
			@RequestParam("sample6_address")String sample6_address, @RequestParam("sample6_extraAddress")String sample6_extraAddress) throws Exception{

    	this.pos = sample6_postcode+" "+sample6_address+" "+sample6_extraAddress+" "+sample6_detailAddress;
    	
        return "redirect:" + kakaopay.kakaoPayReady();
 
    }
    
    @GetMapping("/kakaoPaySuccess") //성공했을때 상품 정보들을 출력
    public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model, HttpSession session)  {
    	
		UserInfo users = (UserInfo)session.getAttribute("userInfo");
		String uid = users.getId();
		Optional<Customer> c = customerRepository.findById(uid);
		
		List<Basket> bList = basketRepository.findByCustomer(c.get());
		
		for(int i=0; i<bList.size(); i++) {
			Sale sale = new Sale();
			List<Sale> sList = new ArrayList<>();
			
			sale.setAddress(this.pos);
			sale.setName(uid);
			sale.setDog(bList.get(i).getDog().getDogBreed());
			sale.setNum(bList.get(i).getNum());
			sale.setPrice(bList.get(i).getDog().getPrice());
			sale.setTotal(bList.get(i).getNum() * bList.get(i).getDog().getPrice());
			sale.setDat(LocalDateTime.now());
			sList.add(sale);
			saleRepository.save(sale);
		}
        model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token));
		
        for(int i=0; i<bList.size(); i++) {			
			basketRepository.delete(bList.get(i));
		}
    }

    
    
    @GetMapping("/kakaoPayCancel") //취소했을때 화면 출력 나오게
    public void kakaoPayCancel() {   
    }
    
    @GetMapping("/kakaoPaySuccessFail") //실패했을때 화면 출력 나오게
    public void kakaoPaySuccessFail() {   
    }
    
}
