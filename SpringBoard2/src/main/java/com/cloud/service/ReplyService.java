package com.cloud.service;

import java.util.List;

import com.cloud.domain.ReplyVO;

public interface ReplyService {
	
	//´ñ±Û ¸ñ·Ï
	public List<ReplyVO> getReplyList(int bno);
	
	//´ñ±Û µî·Ï
	public void register(ReplyVO vo);
	
	//Æ¯Á¤ ´ñ±Û Á¶È¸
	public ReplyVO getReply(int rno);

	//´ñ±Û »èÁ¦
	public void delete(ReplyVO vo);

	//´ñ±Û ¼öÁ¤
	void update(ReplyVO vo);
}
