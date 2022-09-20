package com.cloud.domain;

import java.util.Date;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class ReplyVO {
	
	private int rno;	//��� ��ȣ(�⺻Ű)
	private int bno;	//�۹�ȣ
	
	private String reply;	//��� ����
	private String replyer;	//��� �ۼ���
	private Date replyDate;	//��� �ۼ�����
	private Date updateDate;//��� ��������
}
