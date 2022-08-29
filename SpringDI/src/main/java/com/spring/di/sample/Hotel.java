package com.spring.di.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Component
public class Hotel {
	
	private Chef chef;
	
	/*public Hotel(Chef chef) {
		this.chef = chef;
	}*/
}
