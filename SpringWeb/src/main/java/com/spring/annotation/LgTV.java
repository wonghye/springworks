package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	
	@Autowired
	//@Qualifier("sony")  //의존성 주입될 객체의 아이디를 지정할 수 있음
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("==> LgTV() 객체 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV--전원 켠다. ");
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
