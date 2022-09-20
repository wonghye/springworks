package com.cloud.service;

import java.util.List;

import com.cloud.domain.ReplyVO;

public interface ReplyService {
	
	//��� ���
	public List<ReplyVO> getReplyList(int bno);
	
	//��� ���
	public void register(ReplyVO vo);
	
	//Ư�� ��� ��ȸ
	public ReplyVO getReply(int rno);

	//��� ����
	public void delete(ReplyVO vo);

	//��� ����
	void update(ReplyVO vo);
}
