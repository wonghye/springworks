package com.cloud.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;
import com.cloud.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	/*
	@Test
	public void testGetList() {
		List<BoardVO> list = mapper.getBoardList();
		
		list.stream()
			.map(board -> board.getBno())  // 글번호 매핑
			.forEach(board -> log.info(board));	// 전체 데이터 출력 
	}
	*/
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(2); // 1페이지
		cri.setAmount(10); // 게시글수 - 10개
		
		List<BoardVO> list = mapper.getListWithPage(cri);
		
		list.stream()
		.map(board -> board.getBno())  // 글번호 매핑
		.forEach(board -> log.info(board));	// 전체 데이터 출력 
		
	}
	
	
	
}
