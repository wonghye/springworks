package com.cloud.service;

import java.util.List;

import com.cloud.domain.BoardVO2;
import com.cloud.domain.Criteria2;

public interface BoardService2 {
	
	public List<BoardVO2> getBoardList2(); //글 목록 보기
	
	public List<BoardVO2> getListWithPage(Criteria2 cri); //목록 페이지
	
	public int getTotalCount(Criteria2 cri);  //게시글 총 개수
	
	public void insert2(BoardVO2 vo);  //글쓰기
	
	public BoardVO2 getBoard2(int bno);  //글 상세 보기
	
	public void delete2(BoardVO2 vo);  //글 삭제
	
	public void update2(BoardVO2 vo);  //글 삭제
	
	public void updateCount2(int bno);  //조회수
}