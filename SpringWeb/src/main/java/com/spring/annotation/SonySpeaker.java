package com.spring.annotation;

import org.springframework.stereotype.Component;

//@Component("sony")
public class SonySpeaker implements Speaker{
	
	public SonySpeaker() {
		System.out.println("==> SonySpeaker 按眉 积己");
	}

	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker -- 家府 虐框");
	}

	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker -- 家府 临烙");
	}

}
