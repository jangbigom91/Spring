package kr.co.mustore.admin.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.mustore.vo.Category2Vo;


@Repository
public interface AdminCategory2Repo  extends JpaRepository<Category2Vo, Integer>{

	public List<Category2Vo> findByCode1OrderBySeq(int code1);
}
