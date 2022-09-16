package com.cloud.mapper;

import java.util.List;
import java.util.Map;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;

//DAO ����
public interface BoardMapper {
	
	public List<BoardVO> getBoardList(); //�� ��� ����
	
	public List<BoardVO> getListWithPage(Criteria cri); //��� ������
	
	public int getTotalCount(Criteria cri);  //�Խñ� �� ����
	
	public void insertBoard(BoardVO vo);  //�۾���
	
	public BoardVO getBoard(int bno);  //�� �� ����
	
	public void deleteBoard(BoardVO vo);  //�� ����
	
	public void updateBoard(BoardVO vo);  //�� ����
	
	public void updateCount(int bno);  //��ȸ��
	
	//�˻� ó�� �׽�Ʈ
	List<BoardVO> searchTest(Map<String, Map<String, String>> map); 
}