package kr.co.mustore.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.mustore.vo.TermsVo;


@Repository
public interface TermsRepo extends JpaRepository<TermsVo, Integer>{

}
