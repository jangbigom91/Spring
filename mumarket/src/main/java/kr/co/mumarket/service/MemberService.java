package kr.co.mumarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mumarket.dao.MemberDao;
import kr.co.mumarket.vo.MemberVo;
import kr.co.mumarket.vo.ResultVo;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	
	public ResultVo selectCountUid(String uid) {
		return dao.selectCountUid(uid);
	}
	public MemberVo selectMember(MemberVo vo) {
		return dao.selectMember(vo);
	}
}