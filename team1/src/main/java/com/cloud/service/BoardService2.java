package com.cloud.service;

import java.util.List;

import com.cloud.domain.BoardVO2;

public interface BoardService2 {
   
   public List<BoardVO2> getBoardList2(); //�� ��� ����
   
   public void insert2(BoardVO2 vo);  //�۾���
   
   public BoardVO2 getBoard2(int bno);  //�� �� ����
   
   public void delete2(BoardVO2 vo);  //�� ����
   
   public void update2(BoardVO2 vo);  //�� ����
   
   public void updateCount2(int bno);  //��ȸ��
}