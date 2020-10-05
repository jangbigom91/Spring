package kr.co.mustore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.mustore.vo.ProductsVo;


@Repository
public interface MainDao {
	
	public List<ProductsVo> selectKitsProduct();
	public List<ProductsVo> selectGiftProduct();
	public List<ProductsVo> selectTrainingProduct();
	public List<ProductsVo> selectRetroProduct();
	public List<ProductsVo> selectSaleProduct();
}
