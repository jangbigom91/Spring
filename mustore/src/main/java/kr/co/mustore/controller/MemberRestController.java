package kr.co.mustore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.mustore.service.MemberService;
import kr.co.mustore.vo.ResultVo;


@RestController
public class MemberRestController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/member/checkUid")
	public ResultVo checkUid(String uid) {
		
		return service.selectCountUid(uid);
	}
	
	@GetMapping("/member/checkHp")
	public ResultVo checkHp(String hp) {
		
		return service.selectCountHp(hp);
	}
}
