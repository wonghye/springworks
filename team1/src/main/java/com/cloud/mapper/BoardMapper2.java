package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.BoardVO2;

//DAO ����
public interface BoardMapper2 {
	
	public List<BoardVO2> getBoardList2(); //�� ��� ����
	
	public void insertBoard2(BoardVO2 vo);  //�۾���
	
	public BoardVO2 getBoard2(int bno);  //�� �� ����
	
	public void deleteBoard2(BoardVO2 vo);  //�� ����
	
	public void updateBoard2(BoardVO2 vo);  //�� ����
	
	public void updateCount2(int bno);  //��ȸ��
}