package com.example.petShop1.shopping;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.petShop1.log.UserInfo;
import com.example.petShop1.table.Customer;
import com.example.petShop1.table.CustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CartController {
	private final DogService dogService;
	private final CustomerRepository customerRepository;
	private final BasketRepository basketRepository;

	//카트에 상품추가
	@GetMapping("/add")
	public String add(Integer dogid, HttpSession session, 
			RedirectAttributes rttr, String id) throws Exception{
		
		//추가상품 정보 획득
		Dog selectedDog = this.dogService.read(dogid);
		
		UserInfo users = (UserInfo)session.getAttribute("userInfo");
		String uid = users.getId();

		rttr.addFlashAttribute("msg","SUCCESS");
		Optional<Customer> a = customerRepository.findById(uid);
		List<Basket> bList = basketRepository.findByCustomer(a.get());
		for(Basket b : bList) {
			if(b.getDog().getDogid() == selectedDog.getDogid()) {
				int num = b.getNum();
				b.setNum(num + 1);
				basketRepository.save(b);
				return "redirect:/confirm";
			}
		}
		
		
		Basket b = new Basket();
		b.setNum(1);
		b.setCustomer(a.get());
		b.setDog(selectedDog);
		basketRepository.save(b);
		return "redirect:/confirm";
	}
	
	//카트에 추가한 상품확인
	@GetMapping("/confirm")
	public String confirm(HttpSession session, Model model) throws Exception{
		//카트획득 
		UserInfo users = (UserInfo)session.getAttribute("userInfo");
		String uid = users.getId();
		Optional<Customer> a = customerRepository.findById(uid);
		List<Basket> bList = basketRepository.findByCustomer(a.get());
		model.addAttribute("bList",bList);
		return "confirm";
	}
	
	//카트비우기
	@GetMapping("/clear")
	public String clear(HttpSession session, 
			RedirectAttributes rttr) throws Exception{
		//카트획득
		UserInfo users = (UserInfo)session.getAttribute("userInfo");
		String uid = users.getId();
		Optional<Customer> a = customerRepository.findById(uid);
		List<Basket> bList = basketRepository.findByCustomer(a.get());
		
		//카트비움
		for(int i=0; i<bList.size(); i++) {
			basketRepository.delete(bList.get(i));
		}
		
		
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/confirm";
	}


}
