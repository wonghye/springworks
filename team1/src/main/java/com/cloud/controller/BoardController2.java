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

import com.cloud.domain.BoardVO2;
import com.cloud.domain.Criteria2;
import com.cloud.domain.PageDTO2;
import com.cloud.service.BoardService2;

@RequestMapping("/board/*")  //localhost:8080/board/aaa
@Controller
public class BoardController2 {
	
	@Autowired
	private BoardService2 service2;

	//목록 보기
	/* @GetMapping("/boardList2")//localhost:8080/board/boardList
	public String getBoardList2(Model model) {
		List<BoardVO2> boardList2 = service2.getBoardList2();
		model.addAttribute("boardList2", boardList2); //view로 전송
		return "/board/boardList2";
	} */
	//목록 보기
			@GetMapping("/boardList2")//localhost:8080/board/boardList
			public String getBoardList(Criteria2 cri2, Model model) {
				List<BoardVO2> boardList = service2.getListWithPage(cri2);
				int total = service2.getTotalCount(cri2);
				PageDTO2 pageMaker = new PageDTO2(cri2, total);
				
				model.addAttribute("boardList2", boardList); //view로 전송
				model.addAttribute("pageMaker", pageMaker); //"pageMaker" -> boardList.jsp
				return "/board/boardList2";
			}
	
	//글쓰기 폼 페이지 요청
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/insertBoard2")
	public String insert2() {
		return "/board/insertBoard2";
	}
	
	//글쓰기 처리 요청
	@PostMapping("/insertBoard2")
	@PreAuthorize("isAuthenticated()")
	public String insert2(BoardVO2 vo){
		service2.insert2(vo);      
		return "redirect:/board/boardList2";
	}
	
	//글 상세보기 처리
	@GetMapping("/boardView2")
	public String getBoard2(int bno, Model model) {
		service2.updateCount2(bno);   //조회수 증가
		BoardVO2 board2 = service2.getBoard2(bno); //상세 보기 처리
		model.addAttribute("board2", board2);  //model="board" 보내기
		return "/board/boardView2";
	}
	
	//글 삭제
	@GetMapping("/deleteBoard2")
	public String delete2(BoardVO2 vo) {
		service2.delete2(vo);
		return "redirect:/board/boardList2";
	}
	
	//글 수정
	@PostMapping("/updateBoard2")
	public String update2(BoardVO2 vo) {
		service2.update2(vo);
		return "redirect:/board/boardList2";
	}
	
}