package kr.co.mustore.admin.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.mustore.vo.Category1Vo;


@Repository
public interface AdminCategory1Repo  extends JpaRepository<Category1Vo, Integer>{
		
}
