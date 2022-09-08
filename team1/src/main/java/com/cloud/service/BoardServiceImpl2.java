package com.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.domain.BoardVO2;
import com.cloud.mapper.BoardMapper2;

@Service
public class BoardServiceImpl2 implements BoardService2{
   
   @Autowired
   private BoardMapper2 mapper2;

   @Override
   public List<BoardVO2> getBoardList2() { //��� ����
      return mapper2.getBoardList2();
   }

   @Override
   public void insert2(BoardVO2 vo) { //�۾���
      mapper2.insertBoard2(vo);
   }

   @Override
   public BoardVO2 getBoard2(int bno) {  //�� �� ����
      return mapper2.getBoard2(bno);
   }

   @Override
   public void delete2(BoardVO2 vo) { //�� ���� ����
      mapper2.deleteBoard2(vo);
   }

   @Override
   public void update2(BoardVO2 vo) { //�� ���� ����
      mapper2.updateBoard2(vo);
   }

   @Override
   public void updateCount2(int bno) { //��ȸ�� ����
      mapper2.updateCount2(bno);
   }

}