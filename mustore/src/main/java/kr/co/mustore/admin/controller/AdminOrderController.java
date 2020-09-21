package kr.co.mustore.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminOrderController {
	
	@GetMapping("/admin/order/order-list")
	public String orderList() {
		return "/admin/order/order-list";
	}
}
