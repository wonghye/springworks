package com.cloud.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.domain.BoardVO;
import com.cloud.service.BoardService;

@RequestMapping("/board/*")  // localhost:8080/board/~~
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/boardList") //localhost:8080/board/boardList
	public String getBoardList(Model model) { 
		List<BoardVO> boardList = service.getBoardList();
		model.addAttribute("boardList", boardList);  // view 로 전송
		return "/board/boardList";
	}
	
	//글쓰기 폼 페이지 요청
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/insertBoard")
	public String insert() {
		return "/board/insertBoard";
	}
	
	//글쓰기 처리 요청
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/insertBoard")
	public String insert(BoardVO vo, HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		service.insert(vo);
		return "redirect:/board/boardList";
	}
	
	//글 상세보기 처리
	@GetMapping("/boardView")
	public String getBoard(int bno, Model model) {
		service.updateCount(bno);			 // 조회수 증가
		BoardVO board = service.getBoard(bno);// 상세 보기 처리
		model.addAttribute("board", board);  // model = board 보내기
		return "board/boardView";
	}
	
	//글 삭제
	@GetMapping("/deleteBoard")
	public String delete(BoardVO vo) {
		service.delete(vo);
		return "redirect:/board/boardList";
	}
	
	//글 수정
	@PostMapping("/updateBoard")
	public String update(BoardVO vo) {
		service.update(vo);
		return "redirect:/board/boardList";
	}
	
	
	
	
	
	
}
