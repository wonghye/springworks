package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.BoardVO;

//DAO 역할
public interface BoardMapper {
	
	public List<BoardVO> getBoardList();  // 글 목록 보기
	
	public void insertBoard(BoardVO vo);  // 글 쓰기
	
	public BoardVO getBoard(int bno);  	  // 글 상세보기
	
	public void deleteBoard(BoardVO vo);  // 글 삭제 
	
	public void updateBoard(BoardVO vo);  // 글 수정

	public void updateCount(int bno);     // 조회수
	
	//public void getHit(int hit); 		// 좋아요
}
