package kr.co.mumarket.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.mumarket.vo.ProductsOrderVo;

@Repository
public interface ProductsOrderRepo extends JpaRepository<ProductsOrderVo, Integer>{

}
