package com.spring.service;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.board.BoardDAO;
import com.spring.board.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		//1 스프링 컨테이너 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2 board dao 처리 -> boardService 처리 
		//BoardDAO boardDAO = (BoardDAO) container.getBean("boardDAO");  // 호출
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		//글쓰기
		BoardVO vo = new BoardVO();
		vo.setTitle("안녕하세요");
		vo.setWriter("장그래");
		vo.setContent("지인 추천~");
		//boardDAO.insertBoard(vo);
		boardService.insertBoard(vo);
		
		//글목록
		//List<BoardVO> boardList = boardDAO.getBoardList();
		List<BoardVO> boardList = boardService.getBoardList();
		for(BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
		container.close();
	}

}
