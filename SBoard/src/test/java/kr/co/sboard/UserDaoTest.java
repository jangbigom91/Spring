package kr.co.sboard;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.sboard.dao.UserDao;
import kr.co.sboard.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-test.xml"})
public class UserDaoTest {
	
	@Inject
	private UserDao dao;
	
	@Test
	public void selectTerms() {
		dao.selectTerms();
	}
	
	// @Test - 동시 실행 가능
	public void selectUserCount() {
		int result = dao.selectUserCount("abcd");
		System.out.println("result : "+result);
	}
	
	// @Test - 동시 실행 가능
	public void insertUser() {
		
		UserVO vo = new UserVO();
		vo.setUid("cvbsg");
		vo.setPass1("1234");
		vo.setName("임꺽정");
		vo.setNick("꺽정");
		vo.setEmail("cvbsg@asd.com");
		vo.setHp("010-1203-3453");
		vo.setRegip("192.91.29.23");
		
		dao.insertUser(vo);
	}
	
}
