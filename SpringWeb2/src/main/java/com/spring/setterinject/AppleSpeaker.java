package com.spring.setterinject;

public class AppleSpeaker implements Speaker {

	public AppleSpeaker() {
		System.out.println("==> AppleSpeaker() ��ü ����");
	}
	
	
	@Override
	public void VolumeUp() {
		System.out.println("AppleSpeaker -- �Ҹ� Ű��");
	}

	@Override
	public void VolumeDown() {
		System.out.println("AppleSpeaker -- �Ҹ� ����");
	}
	
	
	
}
