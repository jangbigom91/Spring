package kr.co.mumarket.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.mumarket.vo.MemberVo;

@Repository
public interface MemberRepo extends JpaRepository<MemberVo, String>{

}