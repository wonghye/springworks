package com.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/sample/*")
@Controller
public class SampleController {

	
	/*@GetMapping("/all")
	public void doAll() {
		log.info("모든 사용자 접근할 수 있음");
	}
	*/
	@GetMapping("/all")
	public String doAll() {
		log.info("모든 사용자 접근할 수 있음");
		return "/sample/all";
	}
	
	@GetMapping("/member")
	public void doMember() {
		log.info("로그인한 회원(멤버)");
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("로그인한 관리자만 접근");
	}
	
	
	
	
	
}
