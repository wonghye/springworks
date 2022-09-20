package com.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.domain.ReplyVO;
import com.cloud.mapper.BoardMapper;
import com.cloud.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

	//매퍼 인터페이스 주입(DI) - 객체 bean 생성됨
	@Autowired
	private ReplyMapper replyMapper; 
	
	@Autowired
	private BoardMapper boardMapper;
	
	//댓글 목록
	@Override
	public List<ReplyVO> getReplyList(int bno) {
		return replyMapper.getReplyList(bno);
	}
	
	//댓글 등록 - 댓글 개수 저장 , 트랜잭션 : 작업 완벽하게 완료되지 않으면 취소함
	@Transactional
	@Override
	public void register(ReplyVO vo) {
		//댓글 개수 
		boardMapper.updateReplyCnt(vo.getBno(),1); // 1 : amount 임
		replyMapper.register(vo);
	}
	
	//특정 댓글 조회
	@Override
	public ReplyVO getReply(int rno) {
		return replyMapper.getReply(rno);
	}

	//댓글 삭제
	@Override
	public void delete(ReplyVO vo) {
		boardMapper.updateReplyCnt(vo.getBno(), -1); //-1:amount 임
		replyMapper.delete(vo);
	}

	//댓글 수정
	@Override
	public void update(ReplyVO vo) {
		replyMapper.update(vo);
	}

}
