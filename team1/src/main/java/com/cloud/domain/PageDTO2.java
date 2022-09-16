package com.cloud.domain;

import lombok.Data;

@Data
public class PageDTO2 {
	private int startPage;  //���� ������
	private int endPage;    //������ ������
	private boolean prev, next;  //����, ����
	
	private int total;   //�Խñ� �� ��
	private Criteria2 cri;  //��������ȣ, �������� �Խñ� �� ����
	
	public PageDTO2(Criteria2 cri, int total) { //������
		this.cri = cri;
		this.total = total;
		
		//������(��) ������                 //3/10.0.. 0.3 ->1(�ø�)*10 -> 10page
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		//����������
		this.startPage = this.endPage - 9;
		//���� �� ������               //1.0�� �Ǽ������� �ڵ�����ȯ //74.0/10 ->7.4 ->8
		int realEndPage = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
		
		//�� ������ ����
		this.endPage = realEndPage < endPage ? realEndPage : endPage;
		
		this.prev = this.startPage > 1; //����(�޴�)
		this.next = this.endPage < realEndPage;  //����
	}
}