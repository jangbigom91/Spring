package kr.co.mumarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.mumarket.service.MemberService;
import kr.co.mumarket.vo.ResultVo;

@RestController
public class MemberRestController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/member/checkUid")
	public ResultVo checkUid(String uid) {
		return service.selectCountUid(uid);
	}
	
}