package com.spring.setterinject;

public class SamsungTV implements TV{
	
	private Speaker speaker;  //인터페이스형 참조 객체 변수
	private int price;
	
	public SamsungTV() {
		System.out.println("==> SamsungTV() 객체 생성");
	}
	
	//setter 인젝션
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("==> setSpeaker() 호출");
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV--전원 켠다. (가격:" + price + ")");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV--전원 끈다");
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();  //스피커의 볼륨 키우기
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();  //스피커의 볼륨 키우기
	}

}
