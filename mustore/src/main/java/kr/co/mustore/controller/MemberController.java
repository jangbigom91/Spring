package kr.co.mustore.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.mustore.vo.MemberVo;
import kr.co.mustore.vo.TermsVo;
import kr.co.mustore.persistence.MemberRepo;
import kr.co.mustore.persistence.TermsRepo;

@Controller
public class MemberController {
	
	@Autowired
	private TermsRepo termsRepo;
	@Autowired
	private MemberRepo memberRepo;
	
	@GetMapping("/member/join")
	public String join() {
		return "/member/join";
	}
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
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
	
	@GetMapping("/member/signup")
	public String signup(Model model) {
		
		TermsVo vo = termsRepo.findById(0).get();
		
		model.addAttribute(vo);
		
		return "/member/signup";
	}
}
