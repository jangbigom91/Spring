package kr.co.mustore.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminMemberController {
	
	@GetMapping("/admin/member/member-manage")
	public String memberManage() {
		return "/admin/member/member-manage";
	}
}
