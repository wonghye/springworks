package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.ReplyVO;

public interface ReplyMapper {
	
	//��� ��Ϻ���
	List<ReplyVO> getReplyList(int bno);
	
	//��� ���
	void register(ReplyVO vo);

	//Ư�� ��� ��ȸ
	ReplyVO getReply(int rno);

	//��� ����
	void delete(ReplyVO vo);

	//��� ����
	void update(ReplyVO vo);
}
