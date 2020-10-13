package kr.co.mumarket.dao;

import org.springframework.stereotype.Repository;

import kr.co.mumarket.vo.MemberVo;
import kr.co.mumarket.vo.ResultVo;

@Repository
public interface MemberDao {
	
	public ResultVo selectCountUid(String uid);
	public MemberVo selectMember(MemberVo vo);
}