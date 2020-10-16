package kr.co.mumarket.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.mumarket.vo.Category1Vo;

public interface MainRepo extends JpaRepository<Category1Vo, Integer>{

}