package com.cloud.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {
	private int pageNum;  //������ ��ȣ
	private int amount;   //�������� �Խñ� ��
	
	public Criteria() {  //�⺻ ������(�Ű����� ���� ������)
		this(1, 10);  //�Ű����� ������ ȣ��
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}