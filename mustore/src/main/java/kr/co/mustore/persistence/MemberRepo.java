package kr.co.mustore.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.mustore.vo.MemberVo;

@Repository
public interface MemberRepo extends JpaRepository<MemberVo, String>{

}
