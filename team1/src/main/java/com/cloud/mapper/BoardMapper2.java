package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.BoardVO2;
import com.cloud.domain.Criteria2;

//DAO ����
public interface BoardMapper2 {
	
	public List<BoardVO2> getBoardList2(); //�� ��� ����
	
	public List<BoardVO2> getListWithPage(Criteria2 cri); //��� ������
	
	public int getTotalCount(Criteria2 cri);  //�Խñ� �� ����
	
	public void insertBoard2(BoardVO2 vo);  //�۾���
	
	public BoardVO2 getBoard2(int bno);  //�� �� ����
	
	public void deleteBoard2(BoardVO2 vo);  //�� ����
	
	public void updateBoard2(BoardVO2 vo);  //�� ����
	
	public void updateCount2(int bno);  //��ȸ��
}