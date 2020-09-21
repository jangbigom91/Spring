package kr.co.mustore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubController {
	
	@GetMapping("/sub/delivery-check")
	public String deliveryCheck() {
		return "/sub/delivery-check";
	}
	
	@GetMapping("/sub/event")
	public String event() {
		return "/sub/event";
	}
	
	@GetMapping("/sub/faq")
	public String faq() {
		return "/sub/faq";
	}
	
	@GetMapping("/sub/notice")
	public String notice() {
		return "/sub/notice";
	}
	
	@GetMapping("/sub/qna")
	public String qna() {
		return "/sub/qna";
	}
}
