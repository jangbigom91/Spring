package kr.co.sboard.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.sboard.dao.UserDao;
import kr.co.sboard.vo.TermsVO;
import kr.co.sboard.vo.UserVO;

@Service
public class UserService {
	
	@Inject
	public UserDao dao;
	
	public UserVO selectUser(UserVO vo) {
		return dao.selectUser(vo);
	}
	public void selectUsers() {}
	
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}
	
	public void updateUser() {}
	public void deleteUser() {}
	
	public TermsVO selectTerms() {
		return dao.selectTerms();
	}
	
	public int selectUserCount(String uid) {
		return dao.selectUserCount(uid);
	}
	
	public int selectPassCount(String pass) {
		return dao.selectPassCount(pass);
	}
	
	public int selectNameCount(String name) {
		return dao.selectPassCount(name);
	}
	
	public int selectNickCount(String nick) {
		return dao.selectPassCount(nick);
	}
	
	public int selectEmailCount(String email) {
		return dao.selectEmailCount(email);
	}
	
	public int selectHpCount(String hp) {
		return dao.selectHpCount(hp);
	}
}
