package kr.co.kmarket.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket.admin.service.AdminProductService;
import kr.co.kmarket.vo.ProductsVo;

@Controller
public class AdminProductController {

	@Autowired
	private AdminProductService service;
	
	@GetMapping("/admin/product/list")
	public String list(Model model, String pg) {
		
		int start = service.getLimitStart(pg);
		int total = service.selectCountProducts();
		int pageEnd = service.getPageEnd(total);
		
		List<ProductsVo> products = service.selectProducts(start);
		model.addAttribute("products", products);
		model.addAttribute("pageEnd", pageEnd);
		model.addAttribute("currentPg", pg);
		
		return "/admin/product/list";
	}
	
	@GetMapping("/admin/product/register")
	public String register() {
		return "/admin/product/register";
	}
	
}