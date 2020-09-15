package kr.co.farmstory.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.co.farmstory.service.BoardService;
import kr.co.farmstory.vo.BoardVO;
import kr.co.farmstory.vo.FileVO;

@Controller
public class BoardController {

	@Inject
	private BoardService service;
	
	@GetMapping("/board/write")
	public String write(String group, String cate, Model model) {
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		return "/board/write";
	}
	
	@PostMapping("/board/write")
	public String write(BoardVO vo, HttpServletRequest req) {
		vo.setRegip(req.getRemoteAddr());
		
		MultipartFile file = vo.getFname();
		
		if(file.isEmpty()) {
			vo.setFile(0);
		}else {
			vo.setFile(1);
		}
		
		int seq = service.insertBoard(vo);
		FileVO fvo = service.fileUpload(req, file, seq);
		
		if(fvo != null) {
			service.insertFile(fvo);			
		}
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/list")
	public String list(String group, String cate, String pg, Model model) {
		
		int start = service.getLimitStart(pg);
		int total = service.selectCountBoard(cate);
		int pageEnd = service.getPageEnd(total);
		int count = service.getListCount(total, start);
		
		List<BoardVO> boards = service.selectBoards(start, cate);
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		model.addAttribute("boards", boards);
		model.addAttribute("pageEnd", pageEnd);
		model.addAttribute("currentPg", pg);
		model.addAttribute("count", count);
		
		return "/board/list";
	}
	
	@GetMapping("/board/view")
	public String view(String group, String cate, int seq, Model model) {
		BoardVO vo = service.selectBoard(seq);
		
		model.addAttribute(vo);
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		return "/board/view";
	}
	
	@GetMapping("/board/modify")
	public String modify(String group, String cate, Model model) {
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		return "/board/modify";
	}
	
	@GetMapping("/board/delete")
	public void delete(String group, String cate, Model model) {
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
	}
	
}