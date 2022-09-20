package com.cloud.domain;

import java.util.Date;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class ReplyVO {
	
	private int rno;	//댓글 번호(기본키)
	private int bno;	//글번호
	
	private String reply;	//댓글 내용
	private String replyer;	//댓글 작성자
	private Date replyDate;	//댓글 작성일자
	private Date updateDate;//댓글 수정일자
}
