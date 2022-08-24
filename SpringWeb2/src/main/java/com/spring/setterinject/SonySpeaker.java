package com.spring.setterinject;

public class SonySpeaker implements Speaker{

	public SonySpeaker() {
		System.out.println("==>onySpeaker 按眉 积己");
	}
	
	
	@Override
	public void VolumeUp() {
		System.out.println("SonySpeaker -- 家府 虐框");
	}

	@Override
	public void VolumeDown() {
		System.out.println("SonySpeaker -- 家府 临烙");
	}
	
}
