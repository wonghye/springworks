package com.cloud.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

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
	
	@GetMapping("/boardList2") //localhost:8080/board/boardList
	public String getBoardList2(Model model) { 
		List<BoardVO> boardList = service.getBoardList();
		model.addAttribute("boardList2", boardList);  // view 로 전송
		return "/board/boardList2";
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
	public String insert(BoardVO vo, HttpServletRequest request) throws IllegalStateException, IOException {
		request.setCharacterEncoding("utf-8");
		/*
		//파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) { // 파일이 첨부되었다면
			String fileName = uploadFile.getOriginalFilename();  // 파일 이름
			String filePath = "C:/upload/";  // 파일의 실제 위치
			uploadFile.transferTo(new File(filePath + fileName));
		}
		*/
		service.insert(vo);
		return "redirect:/board/boardList";
	}
	
	//글 상세보기 처리  + 좋아요 추가 해야함
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
	/*
	@GetMapping("/deleteBoard")
	public String delete2(BoardVO vo) {
		service.delete(vo);
		return "redirect:/board/boardList2";
	}
	*/
	
	//글 수정
	@PostMapping("/updateBoard")
	public String update(BoardVO vo) {
		service.update(vo);
		return "redirect:/board/boardList";
	}
	/*
	@PostMapping("/updateBoard")
	public String update2(BoardVO vo) {
		service.update(vo);
		return "redirect:/board/boardList2";
	}
	*/
	
	
	
	
	
}
