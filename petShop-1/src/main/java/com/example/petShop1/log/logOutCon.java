package com.example.petShop1.log;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class logOutCon {
	//로그아웃
	@RequestMapping("/sign_out")
	public String logout(HttpSession session) {
		UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
		session.invalidate();
		return "redirect:/";
	}
}