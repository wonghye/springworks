package com.cloud.domain;

import java.util.Date;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class ReplyVO {
	
	private int rno;	//´ñ±Û¹øÈ£
	private int bno;	//±Û¹øÈ£
	
	private String reply;	//´ñ±Û ³»¿ë
	private String replyer;	//´ñ±Û ÀÛ¼ºÀÚ
	private Date replyDate;	//´ñ±Û ÀÛ¼ºÀÏÀÚ
	private Date updateDate;//´ñ±Û ¼öÁ¤ÀÏÀÚ
}
