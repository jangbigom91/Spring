package kr.co.mustore.admin.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.mustore.vo.ProductsVo;


@Repository
public interface AdminProductsRepo  extends JpaRepository<ProductsVo, Integer>{
		
}
