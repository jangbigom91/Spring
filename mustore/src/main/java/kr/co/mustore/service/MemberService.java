package kr.co.mustore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mustore.dao.MemberDao;
import kr.co.mustore.vo.ResultVo;


@Service
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	
	public ResultVo selectCountUid(String uid) {
		return dao.selectCountUid(uid);
	}
	
	public ResultVo selectCountHp(String hp) {
		return dao.selectCountHp(hp);
	}
}
