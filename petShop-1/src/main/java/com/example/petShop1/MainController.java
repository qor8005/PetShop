package com.example.petShop1;



import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.petShop1.log.LoginInput;
import com.example.petShop1.log.UserInfo;
import com.example.petShop1.table.Customer;
import com.example.petShop1.table.CustomerForm;
import com.example.petShop1.table.CustomerRepository;
import com.example.petShop1.table.CustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {
	private final CustomerRepository customerRepository;
    private final CustomerService customerService;
	
	//찾아오는길
	@GetMapping("/kakaoMap")
	public String kakaoMap() {
		return "kakaoMap";
	}
	
	//주소입력form
	@RequestMapping("/address")
	public String main_address() {
		return "address";
	}
	
	//로그인form
	@GetMapping("/sign_in")
	public String loginForm(LoginInput loginInput) {
		return "sign_in";
	}
	//로그인처리
	@PostMapping("/sign_in")
	public String login(LoginInput loginInput, HttpSession session, RedirectAttributes rttr) {
    	List<Customer> list = this.customerRepository.findAll();
    	
    	for(int i=0; i<list.size(); i++) {
    		if(loginInput.getId().equals(list.get(i).getId()) && loginInput.getPassword().equals(list.get(i).getPassword())) {
    			UserInfo userInfo = new UserInfo(loginInput.getId(), loginInput.getPassword());
    			session.setAttribute("userInfo", userInfo);
    			return "redirect:/";
    		}
    		else {}
    	}
    	rttr.addFlashAttribute("msg","Failed");
		return "redirect:/sign_in";
	}

	//회원가입form
	@GetMapping("/sign_up")
	public String main_sign_up(CustomerForm customerForm) {
		return "sign_up";
	}
	
	@PostMapping("/sign_up")
	public String main_sign_up(@Valid CustomerForm customerForm, BindingResult bindingResult, 
			@RequestParam("yy")String yy, @RequestParam("mm")String mm,
			@RequestParam("dd")String dd, @RequestParam("gender")String gender) {
    	
		if (bindingResult.hasErrors()) {
            return "sign_up";
        }

		String bir = yy+"-"+mm+"-"+dd;
		customerForm.setBirth(bir);
		customerForm.setGender(gender);
		
		Customer customer = new Customer();
		
		customer.setId(customerForm.getId());
		customer.setPassword(customerForm.getPassword());
		customer.setName(customerForm.getName());
		customer.setBirth(customerForm.getBirth());
		customer.setGender(customerForm.getGender());
		customer.setEmail(customerForm.getEmail());
		customer.setPon(customerForm.getPon());
		
		customerRepository.save(customer);
    	
    	return "redirect:/";
	}
	
}
