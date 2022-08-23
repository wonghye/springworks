package com.spring.setterinject;

public class AppleSpeaker implements Speaker {

	public AppleSpeaker() {
		System.out.println("==> AppleSpeaker() 按眉 积己");
	}
	
	
	@Override
	public void VolumeUp() {
		System.out.println("AppleSpeaker -- 家府 虐框");
	}

	@Override
	public void VolumeDown() {
		System.out.println("AppleSpeaker -- 家府 临烙");
	}
	
	
	
}
