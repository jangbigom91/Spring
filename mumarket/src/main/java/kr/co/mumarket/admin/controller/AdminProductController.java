package kr.co.mumarket.admin.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mumarket.admin.persistence.AdminCategory1Repo;
import kr.co.mumarket.admin.persistence.AdminCategory2Repo;
import kr.co.mumarket.admin.service.AdminProductService;
import kr.co.mumarket.vo.Category1Vo;
import kr.co.mumarket.vo.Category2Vo;
import kr.co.mumarket.vo.ProductsVo;

@Controller
public class AdminProductController {

	@Autowired
	private AdminProductService service;
	
	@Autowired
	private AdminCategory1Repo cate1Repo;
	@Autowired
	private AdminCategory2Repo cate2Repo;
	
	@ResponseBody
	@GetMapping("/admin/product/delete")
	public int delete(String[] codes) {
		
		return service.deleteProduct(codes);
	}
	
	
	@GetMapping("/admin/product/search")
	public String search(String pg, String keyword, String opt, Model model) {
		
		int start = service.getLimitStart(pg);
		int total = service.selectCountProducts();
		int pageEnd = service.getPageEnd(total);
		
		List<ProductsVo> products = service.selectProductsBySearch(start, opt, keyword);
		model.addAttribute("products", products);
		model.addAttribute("pageEnd", pageEnd);
		model.addAttribute("currentPg", pg);
		
		return "/admin/product/list";
	}
	
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
	
	@PostMapping("/admin/product/register")
	public String register(ProductsVo vo, HttpServletRequest req) throws Exception {

		vo.setIp(req.getRemoteAddr());
		vo.setRdate(LocalDateTime.now().toString());
		
		vo = service.uploadThumb(vo);
		service.insertProduct(vo);
		
		return "redirect:/admin/product/register";
		
		// AdminProductService 쪽으로 이동
		// 썸네일 업로드
		//String path = new File("src/main/resources/static/thumb/").getAbsolutePath();
		
		// 확장자 추출
		//String name1 = vo.getFile1().getOriginalFilename(); // 파일명 구분
		//String ext1 = name1.substring(name1.lastIndexOf(".")); // 확장자 구분
		
		//String name2 = vo.getFile2().getOriginalFilename(); // 파일명 구분
		//String ext2 = name2.substring(name2.lastIndexOf(".")); // 확장자 구분
		
		//String name3 = vo.getFile3().getOriginalFilename(); // 파일명 구분
		//String ext3 = name3.substring(name3.lastIndexOf(".")); // 확장자 구분
		
		//String name4 = vo.getFile4().getOriginalFilename(); // 파일명 구분
		//String ext4 = name4.substring(name4.lastIndexOf(".")); // 확장자 구분
		
		// 고유파일명 생성
		//String uName1 = UUID.randomUUID().toString()+ext1;
		//String uName2 = UUID.randomUUID().toString()+ext2;
		//String uName3 = UUID.randomUUID().toString()+ext3;
		//String uName4 = UUID.randomUUID().toString()+ext4;
		
		//String fullPath1 = path+"/"+uName1;
		//String fullPath2 = path+"/"+uName2;
		//String fullPath3 = path+"/"+uName3;
		//String fullPath4 = path+"/"+uName4;
		
		//vo.getFile1().transferTo(new File(fullPath1));
		//vo.getFile2().transferTo(new File(fullPath2));
		//vo.getFile3().transferTo(new File(fullPath3));
		//vo.getFile4().transferTo(new File(fullPath4));
		
	}
	
	@ResponseBody
	@GetMapping("/admin/product/cate1")
	public List<Category1Vo> getCate1() {
		return cate1Repo.findAll();
	}
	
	@ResponseBody
	@GetMapping("/admin/product/cate2")
	public List<Category2Vo> getCate2(int code1) {
		return cate2Repo.findByCode1OrderBySeq(code1);
	}
}