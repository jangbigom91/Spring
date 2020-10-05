package kr.co.mustore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mustore.service.MainService;
import kr.co.mustore.vo.ProductsVo;


@Controller
public class MainController {
	
	@Autowired
	private MainService service;
	
	@GetMapping(value={"/", "/index"})
	public String index(Model model) {
		
		List<ProductsVo> hitList = service.selectKitsProduct();
		List<ProductsVo> bestList = service.selectGiftProduct();
		
		model.addAttribute("hitList", hitList);
		model.addAttribute("bestList", bestList);
		
		return "/index";
	}
	
	@ResponseBody
	@GetMapping("/main/training")
	public List<ProductsVo> training() {
		
		return service.selectTrainingProduct();
	}
	
	@ResponseBody
	@GetMapping("/main/retroItems")
	public List<ProductsVo> retroItems() {
		
		return service.selectRetroProduct();
	}
	
	@ResponseBody
	@GetMapping("/main/giftItems")
	public List<ProductsVo> giftItems() {
		
		return service.selectGiftProduct();
	}
	
	@ResponseBody
	@GetMapping("/main/saleItems")
	public List<ProductsVo> saleItems() {
		
		return service.selectSaleProduct();
	}
}
