package kr.co.kmarket.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.co.kmarket.dao.ShopDao;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductCartVo;
import kr.co.kmarket.vo.ProductsVo;

@Service
public class ShopService {
	
	@Autowired
	private ShopDao dao;
	
	public List<ProductsVo> selectProducts(int cate1, int cate2, int sort){
		return dao.selectProducts(cate1, cate2, sort);
	}
	
	public ProductsVo selectProduct(int code) {
		return dao.selectProduct(code);
	}
	
	public int insertCart(ProductCartVo vo) {
		return dao.insertCart(vo);
	}
	
	public String[] getTitles(HttpSession sess, int cate1, int cate2) {
		List<CategoriesVo> categories = (List<CategoriesVo>) sess.getAttribute("cate1List");
		String tit1 = categories.get(cate1-1).getTitle();
		String tit2 = categories.get(cate1-1).getCate2List().get(cate2-1).getTitle();
		
		String[] tits = {tit1, tit2};
		return tits;
	}
	
}
