package com.spring.setterinject;

public class SonySpeaker implements Speaker{

	public SonySpeaker() {
		System.out.println("==>onySpeaker ��ü ����");
	}
	
	
	@Override
	public void VolumeUp() {
		System.out.println("SonySpeaker -- �Ҹ� Ű��");
	}

	@Override
	public void VolumeDown() {
		System.out.println("SonySpeaker -- �Ҹ� ����");
	}
	
}
