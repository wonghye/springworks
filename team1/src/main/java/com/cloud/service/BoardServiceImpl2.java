package com.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.domain.BoardVO2;
import com.cloud.domain.Criteria2;
import com.cloud.mapper.BoardMapper2;

@Service
public class BoardServiceImpl2 implements BoardService2{
	
	@Autowired
	private BoardMapper2 mapper2;

	@Override
	public List<BoardVO2> getBoardList2() { //목록 보기
		return mapper2.getBoardList2();
	}

	@Override
	public void insert2(BoardVO2 vo) { //글쓰기
		mapper2.insertBoard2(vo);
	}

	@Override
	public BoardVO2 getBoard2(int bno) {  //글 상세 보기
		return mapper2.getBoard2(bno);
	}

	@Override
	public void delete2(BoardVO2 vo) { //글 삭제 서비스
		mapper2.deleteBoard2(vo);
	}

	@Override
	public void update2(BoardVO2 vo) { //글 수정 서비스
		mapper2.updateBoard2(vo);
	}

	@Override
	public void updateCount2(int bno) { //조회수 서비스
		mapper2.updateCount2(bno);
	}

	@Override
	public List<BoardVO2> getListWithPage(Criteria2 cri) {
		return mapper2.getListWithPage(cri);
	}

	@Override
	public int getTotalCount(Criteria2 cri) {
		return mapper2.getTotalCount(cri);
	}

}