package kr.co.mumarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.mumarket.vo.ProductCartVo;
import kr.co.mumarket.vo.ProductsVo;

@Repository
public interface ShopDao {

	public List<ProductsVo> selectProducts(int cate1, int cate2, int sort);
	
	public ProductsVo selectProduct(int code);
	
	public int insertCart(ProductCartVo vo);
	
}