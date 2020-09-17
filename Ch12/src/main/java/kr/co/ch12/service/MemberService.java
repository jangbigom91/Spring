package kr.co.ch12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch12.persistence.MemberRepo;
import kr.co.ch12.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepo repo;
	
	public void insertMember(MemberVO vo) {
		repo.save(vo);
	}
	
	public MemberVO selectMember(String uid) {
		return repo.findById(uid).get();
	}
	
	public List<MemberVO> selectMembers() {
		return repo.findAll();
	}
	
	public void updateMember(MemberVO vo) {
		repo.save(vo);
	}
	
	public void deleteMember(String uid) {
		repo.deleteById(uid);
	}
}
