package kr.co.kmarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductCartVo;
import kr.co.kmarket.vo.ProductsVo;

@Repository
public interface ShopDao {
	
	public List<ProductsVo> selectProducts(int cate1, int cate2, int sort);
	
	public ProductsVo selectProduct(int code);
	
	public int insertCart(ProductCartVo vo);
	
	public List<ProductCartVo> selectCart(String uid);
	
	public int deleteCart(String uid, int[] codes);
}
