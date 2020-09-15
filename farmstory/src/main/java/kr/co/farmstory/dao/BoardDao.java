package kr.co.farmstory.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.JsonObject;

import kr.co.farmstory.vo.BoardVO;
import kr.co.farmstory.vo.FileVO;

@Repository
public class BoardDao {

	@Inject
	private SqlSessionTemplate mybatis;
	
	
	public int insertBoard(BoardVO vo) {
		// ���� insert ���� �� �ش� ���̺� ���� seq���� vo��ü seq����� ����
		mybatis.insert("mapper.board.INSERT_BOARD", vo);
		return vo.getSeq();
	}
	
	public void insertFile(FileVO fvo) {
		mybatis.insert("mapper.board.INSERT_FILE", fvo);
	}
	
	public BoardVO selectBoard(int seq) {
		return mybatis.selectOne("mapper.board.SELECT_BOARD", seq);
	}
	
	public List<BoardVO> selectBoards(int start, String cate) {
		
		Map<String, Object> values = new HashMap<>();
		values.put("start", start);
		values.put("cate", cate);
		
		return mybatis.selectList("mapper.board.SELECT_BOARDS", values);
	}
	
	public int selectCountBoard(String cate) {
		return mybatis.selectOne("mapper.board.SELECT_COUNT_BOARD", cate);
	}
	
	public void updateBoard() {}
	public void deleteBoard() {}
	
	public List<BoardVO> selectLatest(String cate) {
		return mybatis.selectList("mapper.board.SELECT_LATEST", cate);
	}
	
	
	
	
}