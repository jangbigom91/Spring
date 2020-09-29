package kr.co.mustore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.mustore.service.MainService;
import kr.co.mustore.vo.ProductsVo;


@Controller
public class MainController {
	
	@Autowired
	private MainService service;
	
	@GetMapping(value={"/", "/index"})
	public String index(Model model) {
		
		List<ProductsVo> hitList = service.selectHitProduct();
		List<ProductsVo> bestList = service.selectBestProduct();
		
		model.addAttribute("hitList", hitList);
		model.addAttribute("bestList", bestList);
		
		return "/index";
	}
}
