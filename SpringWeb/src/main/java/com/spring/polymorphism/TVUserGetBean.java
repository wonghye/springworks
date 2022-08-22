package com.spring.polymorphism;

public class TVUserGetBean {

	public static void main(String[] args) {
		// factory °´Ã¼ »ý¼º
		BeanFactory factory = new BeanFactory();
		
		TV tv = (TV)factory.getBean(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeUp();
		tv.powerOff();
	}

}
