package com.example.petShop1.notice;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.petShop1.log.UserInfo;
import com.example.petShop1.table.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService service;
	private final CustomerRepository customerRepository;

	@GetMapping("/register")
	public void registerForm(Board board, Model model) throws Exception{
	}
	
	@PostMapping("/register")
	public String register(Board board, Model model, HttpSession session) throws Exception{

		UserInfo users = (UserInfo)session.getAttribute("userInfo");
		System.out.println("-----------------------"+users+"*****************");
		String uid = users.getId();
		service.register(board,uid);

		model.addAttribute("msg","등록이 완료되었습니다.");
		return "board/success";
	}

	
	@GetMapping("/list")
	public void list(Model model) throws Exception{
		model.addAttribute("list",service.list());
	}
	
	@GetMapping("/read")
	public void readForm(Integer bodid, Model model, HttpSession session) throws Exception{
		UserInfo users = (UserInfo)session.getAttribute("userInfo");
		System.out.println("-----------------------"+users+"*****************");
		model.addAttribute(service.read(bodid));
		model.addAttribute("userInfo", users);
	}

	
	@GetMapping("/modify")
	public void modifyForm(Integer bodid, Model model) throws Exception{
		model.addAttribute(service.read(bodid));
	}
	
	@PostMapping("/modify")
	public String modify(Board board, Model model) throws Exception{
		service.modify(board);
		
		model.addAttribute("msg","수정이 완료되었습니다.");
		return "board/success";
	}
	
	@PostMapping("/remove")
	public String remove(Integer bodid, Model model) throws Exception{
		service.remove(bodid);
		
		model.addAttribute("msg","삭제가 완료되었습니다.");
		return "board/success";
	}
}
