package kr.co.mustore.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminProductController {
	
	@GetMapping("/admin/product/register-product")
	public String registerProduct() {
		return "/admin/product/register-product";
	}
}
