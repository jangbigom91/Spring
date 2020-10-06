package kr.co.kmarket.controller;


import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.kmarket.persistence.MemberRepo;
import kr.co.kmarket.persistence.TermsRepo;
import kr.co.kmarket.vo.MemberVo;
import kr.co.kmarket.vo.TermsVo;

@Controller
public class MemberController {
	
	@Autowired
	private TermsRepo termsRepo;
	@Autowired
	private MemberRepo memberRepo;
	
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	@GetMapping("/member/join")
	public String join() {
		return "/member/join";
	}
	
	@GetMapping("/member/signup")
	public String signup(String type, Model model) {
		
		TermsVo vo = termsRepo.findById(0).get();
		
		model.addAttribute("type", type);
		model.addAttribute(vo);
		
		return "/member/signup";
	}
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("/member/register")
	public String register(MemberVo vo, HttpServletRequest req) {
		
		vo.setIp(req.getRemoteAddr()); // SQL 쿼리문에서 기본값이 없기때문에 따로 설정
		vo.setRdate(LocalDateTime.now().toString()); // SQL 쿼리문에서  기본값이 없기때문에 따로 설정
		
		memberRepo.save(vo);
		
		return "redirect:/member/login";
	}
	
	@GetMapping("/member/register-seller")
	public String registerSeller() {
		return "/member/register-seller";
	}
	
	@PostMapping("/member/register-seller")
	public String registerSeller(MemberVo vo, HttpServletRequest req) {
		
		vo.setIp(req.getRemoteAddr()); // SQL 쿼리문에서 기본값이 없기때문에 따로 설정
		vo.setRdate(LocalDateTime.now().toString()); // SQL 쿼리문에서  기본값이 없기때문에 따로 설정
		
		memberRepo.save(vo);
		
		return "redirect:/member/login";
	}
	
}
