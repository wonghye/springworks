package com.spring.annotation;

import org.springframework.stereotype.Component;

/*@Component("sony")*/
public class SonySpeaker implements Speaker{

	public SonySpeaker() {
		System.out.println("==>SonySpeaker ��ü ����");
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
