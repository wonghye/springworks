package com.cloud.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.repository.BoardVO;
import com.cloud.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;  //서비스 객체 생성
	
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public String getBoardList(Model model) {
		List<BoardVO> boardList = service.getBoardList();
		model.addAttribute("boardList", boardList); //jsp쪽으로 리스트 보냄
		return "boardList";
	}
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.GET)
	public String insertBoardView() {  //글쓰기 폼 페이지 요청
		return "insertBoard";
	}
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo) {  //글쓰기 처리 요청
		//파라미터의 객체를 커맨드 객체라고 함. (폼 데이터를 전달받고 세팅)
		service.insertBoard(vo);
		return "redirect:boardList";
	}
	
	/*@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(HttpServletRequest request) throws UnsupportedEncodingException {  //글쓰기 폼 페이지 요청
		//사용자 입력 정보 추출
		request.setCharacterEncoding("utf-8"); //한글 인코딩 요청
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//db 연동
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		service.insertBoard(vo);
		return "redirect:boardList";
	}*/
	
	@GetMapping("/boardView")
	public String getBoard(int bno, Model model) { //상세보기 페이지 요청
		service.updateCount(bno);
		BoardVO board = service.getBoard(bno);
		model.addAttribute("board", board);  //jsp로 board 데이터 보냄
		return "boardView";
	}
	
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(BoardVO vo) { //글삭제 처리 요청
		service.deleteBoard(vo);
		return "redirect:boardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(BoardVO vo) {
		service.updateBoard(vo);
		return "redirect:boardList";
	}
	
}
