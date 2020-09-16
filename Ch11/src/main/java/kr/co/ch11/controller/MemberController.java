package kr.co.ch11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch11.service.MemberService;
import kr.co.ch11.vo.MemberVO;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("/member/register")
	public String register(MemberVO vo) {
		
		service.insertMember(vo);
		
		return "redirect:/member/list";
	}
	
	@GetMapping("/member/list")
	public String list(Model model) {
		List<MemberVO> members = service.selectMembers();
		model.addAttribute("members", members);
		return "/member/list";
	}
	
	@GetMapping("/member/modify")
	public String modify(String uid, Model model) {
		
		MemberVO vo = service.selectMember(uid);
		model.addAttribute(vo);
		
		return "/member/modify";
	}
	
	@PostMapping("/member/modify")
	public String modify(MemberVO vo) {
		service.updateMember(vo);
		return "redirect:/member/list";
	}
	
	@GetMapping("/member/delete")
	public String delete(String uid) {
		
		service.deleteMember(uid);
		
		return "redirect:/member/list";
	}
}
