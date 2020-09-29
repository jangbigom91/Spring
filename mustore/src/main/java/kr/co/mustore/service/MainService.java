package kr.co.mustore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mustore.dao.MainDao;
import kr.co.mustore.vo.ProductsVo;


@Service
public class MainService {
	
	@Autowired
	private MainDao dao;
	
	public List<ProductsVo> selectHitProduct() {
		return dao.selectHitProducts();
	}
	
	public List<ProductsVo> selectBestProduct() {
		return dao.selectBestProducts();
	}
}
