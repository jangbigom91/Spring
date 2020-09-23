package kr.co.mustore.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.mustore.vo.ProductsVo;


@Repository
public interface AdminProductDao {
		
	public void insertProduct(ProductsVo vo); 
	public ProductsVo selectProduct(); 
	public List<ProductsVo> selectProducts(int start);
	
	public int selectCountProducts();
	
	public void updateProduct(); 
	public void deleteProduct(); 
	
}