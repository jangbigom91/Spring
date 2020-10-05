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
	
	public List<ProductsVo> selectKitsProduct() {
		return dao.selectKitsProduct();
	}
	
	public List<ProductsVo> selectGiftProduct() {
		return dao.selectGiftProduct();
	}
	
	public List<ProductsVo> selectTrainingProduct() {
		return dao.selectTrainingProduct();
	}
	
	public List<ProductsVo> selectRetroProduct() {
		return dao.selectRetroProduct();
	}
	
	public List<ProductsVo> selectSaleProduct() {
		return dao.selectSaleProduct();
	}
}
