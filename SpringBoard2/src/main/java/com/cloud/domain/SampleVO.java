package com.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor	// �⺻ ������ ����� ��� �ʿ�
@AllArgsConstructor
@Data
public class SampleVO {
	
	//�ʵ�
	private Integer mno;		//ȸ����ȣ
	private String firstName;	//�̸�
	private String lastName;	//��
	
	
	
}
