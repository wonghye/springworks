package com.spring.consinject;


public class SamsungTV implements TV{
	
	private SonySpeaker speaker;  //참조 객체 변수
	
	//생성자 인젝션
	public SamsungTV(SonySpeaker speaker) { //객체가 매개변수인 생성자
		this.speaker = speaker; 
		System.out.println("SamsungTV() 객체 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV--전원 켠다");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV--전원 끈다");
	}

	@Override
	public void volumeUp() {
		speaker.volumnUp();
	}

	@Override
	public void volumeDown() {
		speaker.volumnDown();
	}

}
