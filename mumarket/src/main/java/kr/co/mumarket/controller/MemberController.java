package kr.co.mumarket.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.mumarket.persistance.MemberRepo;
import kr.co.mumarket.persistance.TermsRepo;
import kr.co.mumarket.service.MemberService;
import kr.co.mumarket.vo.MemberVo;
import kr.co.mumarket.vo.TermsVo;

@Controller
public class MemberController {
	
	@Autowired
	private TermsRepo termsRepo;
	@Autowired
	private MemberRepo memberRepo;
	@Autowired
	private MemberService service;
	
	@GetMapping("/member/logout")
	public String logout(HttpSession sess) {
		sess.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/member/login")
	public String login(String success, Model model) {
		model.addAttribute("success", success);
		return "/member/login";
	}
	
	@PostMapping("/member/login")
	public String login(MemberVo vo, HttpSession sess) {
		
		MemberVo member = service.selectMember(vo);
		
		if(member != null) {
			sess.setAttribute("member", member);
			sess.setAttribute("type", member.getType());
			return "redirect:/index";
		}else {
			return "redirect:/member/login?success=fail";	
		}
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
		
		vo.setIp(req.getRemoteAddr());
		vo.setRdate(LocalDateTime.now().toString());
		
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
	
	@GetMapping("/member/findUid")
	public String findUid() {
		return "/member/findUid";
	}
	
	@GetMapping("/member/findPass")
	public String findPass() {
		return "/member/findPass";
	}
}