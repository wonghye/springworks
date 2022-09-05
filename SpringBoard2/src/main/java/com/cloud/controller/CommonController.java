package com.cloud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {
	//에러처리
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		model.addAttribute("msg","해당 메뉴는 관리자에게만 제공됩니다.");
	}
	
	// 로그인 폼 페이지 요청
	@GetMapping("/customLogin")
	public void login(String error, String logout, Model model) {
		log.info("error : " +  error);
		log.info("logout : " +  logout);
	
		if(error != null) {
			model.addAttribute("error", "아이디나 비밀번호를 확인해 주세요!");
		}
		if(logout != null) {
			model.addAttribute("logout", "로그아웃!");
		}
	
	}
	
	//로그아웃 처리
	@GetMapping("/customLogout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션삭제
		
		log.info("custom logout");
		return "redirect:/";
	}
	
	
}
