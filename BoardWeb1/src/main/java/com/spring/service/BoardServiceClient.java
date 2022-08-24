package com.spring.service;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.board.BoardDAO;
import com.spring.board.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		//1 ������ �����̳� ����
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2 board dao ó�� -> boardService ó�� 
		//BoardDAO boardDAO = (BoardDAO) container.getBean("boardDAO");  // ȣ��
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		//�۾���
		BoardVO vo = new BoardVO();
		vo.setTitle("�ȳ��ϼ���");
		vo.setWriter("��׷�");
		vo.setContent("���� ��õ~");
		//boardDAO.insertBoard(vo);
		boardService.insertBoard(vo);
		
		//�۸��
		//List<BoardVO> boardList = boardDAO.getBoardList();
		List<BoardVO> boardList = boardService.getBoardList();
		for(BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
		container.close();
	}

}
