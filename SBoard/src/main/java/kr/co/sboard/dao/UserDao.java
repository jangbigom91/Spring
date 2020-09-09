package kr.co.sboard.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.TermsVO;
import kr.co.sboard.vo.UserVO;

@Repository
public class UserDao {
	
	@Inject
	private SqlSessionTemplate mybatis;
	
	public UserVO selectUser(UserVO vo) {
		return mybatis.selectOne("mapper.user.SELECT_USER", vo);
	}
	
	
	public void selectUsers() {}
	
	public void insertUser(UserVO vo) {
		mybatis.insert("mapper.user.INSERT_USER", vo);
	}
	
	public void updateUser() {}
	public void deleteUser() {}
	
	public TermsVO selectTerms() {
		return mybatis.selectOne("mapper.user.SELECT_TERMS");
	}
	
	public int selectUserCount(String uid) {
		return mybatis.selectOne("mapper.user.SELECT_USER_COUNT", uid);
	}
	
	public int selectPassCount(String pass) {
		return mybatis.selectOne("mapper.user.SELECT_CHECK_PASS", pass);
	}
	
	public int selectNameCount(String name) {
		return mybatis.selectOne("mapper.user.SELECT_CHECK_NAME", name);
	}
	
	public int selectNickCount(String nick) {
		return mybatis.selectOne("mapper.user.SELECT_CHECK_NICK", nick);
	}
	
	public int selectEmailCount(String email) {
		return mybatis.selectOne("mapper.user.SELECT_CHECK_EMAIL", email);
	}
	
	public int selectHpCount(String hp) {
		return mybatis.selectOne("mapper.user.SELECT_CHECK_HP", hp);
	}
}
