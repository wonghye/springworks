package com.spring.setterinject;

public class LgTV implements TV{
	
	private Speaker speaker;
	private int price;
	
	public LgTV() {
		System.out.println("==> LgTV() 객체 생성");
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
		System.out.println("LgTV--전원 켠다. (가격: "+ price + ")");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV--전원 켠다");
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}

}
