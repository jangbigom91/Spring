package kr.co.sboard.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sboard.dao.BoardDao;
import kr.co.sboard.vo.BoardVO;
import kr.co.sboard.vo.FileVO;

@Service
public class BoardService {

	@Autowired
	private BoardDao dao;
	
	public int insertBoard(BoardVO vo) {
		int seq = dao.insertBoard(vo);
		return seq;
	}
	
	public void insertFile(FileVO fvo) {
		dao.insertFile(fvo);
	}
	public BoardVO selectBoard(int seq) {
		return dao.selectBoard(seq);
	}
	
	public List<BoardVO> selectBoards(int start) {
		return dao.selectBoards(start);
	}
	
	// Limit start 계산
	public int getLimitStart(String pg) {
		
		int start = 0;
		
		if(pg == null) {
			start = 1;
		}else {
			start = Integer.parseInt(pg);
		}
		
		return start;
	}
	
	// 전체 게시물 갯수
	public int selectCountBoard(){
		return dao.selectCountBoard();
	}
	
	// 페이지 번호 계산
	public int getPageEnd(int total) {
		
		int pageEnd = 0;
		
		if(total % 10 == 0) {
			pageEnd = total / 10;
		}else {
			pageEnd = (total / 10) + 1;
		}
		return pageEnd;
	}
	
	// list count 계산
	public int getListCount(int total, int start) {
		return total - start;
	}
	
	// start limit
	public int getStartLimit(int start) {
		int startLimit = (start - 1) * 10;
		
		return startLimit;
	}
	
	// 그룹화
	public int getGroupCurrent(int start) {
		return (int)Math.ceil(start / 10.0);
	}
	
	public int getGroupStart(int groupCurrent) {
		return (groupCurrent - 1) * 10 + 1;
	}
	
	public int getGroupEnd(int groupCurrent) {
		return groupCurrent * 10;
	}
	
	// 파일 업로드
	public FileVO fileUpload(HttpServletRequest req, MultipartFile file, int seq) {
		
		String path = req.getSession().getServletContext().getRealPath("/resources/files/");
		
		if(!file.isEmpty()) {
			// 파일 첨부 했을때
			String oName = file.getOriginalFilename();
			String ext = oName.substring(oName.lastIndexOf("."));
			
			// 고유파일명 생성
			String uName = UUID.randomUUID().toString()+ext;
			
			// 파일 저장
			try {
				file.transferTo(new File(path+uName));
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			FileVO vo = new FileVO();
			vo.setParent(seq);
			vo.setOldName(oName);
			vo.setNewName(uName);
			
			return vo;
			
		}else {
			// 파일 첨부 안했을때
			return null;
		}	
	}
		
	// 파일 다운로드
	public void fileDownload() {
		
	}
	
}