package kr.co.mumarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mumarket.dao.MainDao;
import kr.co.mumarket.vo.CategoriesVo;
import kr.co.mumarket.vo.ProductsVo;

@Service
public class MainService {
	
	@Autowired
	private MainDao dao;
	
	public List<CategoriesVo> selectCategories() {
		return dao.selectCategories();
	}
	
	public List<ProductsVo> selectHitProduct() {
		return dao.selectHitProduct();
	}
	
	public List<ProductsVo> selectBestProduct() {
		return dao.selectBestProduct();
	}
	
	public List<ProductsVo> selectRecProduct() {
		return dao.selectRecProduct();
	}
	
	public List<ProductsVo> selectNewProduct() {
		return dao.selectNewProduct();
	}
	
	public List<ProductsVo> selectDiscountProduct() {
		return dao.selectDiscountProduct();
	}
}