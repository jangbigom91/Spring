package kr.co.mustore.dao;

import org.springframework.stereotype.Repository;

import kr.co.mustore.vo.ResultVo;


@Repository
public interface MemberDao {
	
	public ResultVo selectCountUid(String uid);
	public ResultVo selectCountHp(String hp);
}
