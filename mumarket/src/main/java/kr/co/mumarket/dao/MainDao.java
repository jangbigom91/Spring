  
package kr.co.mumarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.mumarket.vo.CategoriesVo;
import kr.co.mumarket.vo.ProductsVo;

@Repository
public interface MainDao {

	public List<CategoriesVo> selectCategories();
	public List<ProductsVo> selectHitProduct();
	public List<ProductsVo> selectBestProduct();
	public List<ProductsVo> selectRecProduct();
	public List<ProductsVo> selectNewProduct();
	public List<ProductsVo> selectDiscountProduct();
	
	
}