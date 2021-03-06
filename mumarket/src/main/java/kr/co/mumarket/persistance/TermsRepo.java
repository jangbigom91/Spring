package kr.co.mumarket.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.mumarket.vo.TermsVo;

@Repository
public interface TermsRepo extends JpaRepository<TermsVo, Integer> {

}