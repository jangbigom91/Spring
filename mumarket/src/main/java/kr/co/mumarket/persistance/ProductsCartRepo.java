package kr.co.mumarket.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.mumarket.vo.ProductsCartVo;

@Repository
public interface ProductsCartRepo extends JpaRepository<ProductsCartVo, Integer>{

}
