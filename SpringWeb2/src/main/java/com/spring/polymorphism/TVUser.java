package com.spring.polymorphism;

public class TVUser {

	public static void main(String[] args) {
		TV tv = new LgTV(); // 인터페이스형 객체(인스턴스) 생성
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		
		//인터페이스형 객체(인스턴스) 생성해서 묵시적 형변환(자동형변환)을 이용하여
		//객체를 참조하면 쉽게 교체 가능
	}

}
