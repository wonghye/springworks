package com.cloud.service;

import java.util.List;

import com.cloud.repository.BoardVO;

public interface BoardService {
	
	public void insertBoard(BoardVO vo); //글쓰기(추가)
	
	public List<BoardVO> getBoardList(); //목록 보기
	
	public BoardVO getBoard(int bno);  // 글 상세보기
	
	public void deleteBoard(BoardVO vo); //  글 삭제
	
	public void updateBoard(BoardVO vo);  // 글 수정
	
	public void updateCount(int bno);   // 조회수 증가
	
	
}
