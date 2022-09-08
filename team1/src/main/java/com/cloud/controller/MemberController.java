package com.cloud.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.domain.MemberVO;
import com.cloud.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@RequestMapping("/member/*")
@Controller
public class MemberController {
   
   @Autowired
      private PasswordEncoder pwencoder;
   
   private MemberService service;  //생성자 주입
   
   //회원 가입 폼 요청
   @GetMapping("/signup")
   public void signUp() {
      log.info("회원 가입 폼");
   }
   
   //회원 가입 처리
   @PostMapping("/signup")
   public String signUp(MemberVO member) {
      service.signup(member);
      return "redirect:/customLogin";
   }
   
   //ID 중복 체크
   @GetMapping("/checkID")
   @ResponseBody
   public int checkID(String userid) {
     int result = service.checkID(userid);
     return result;
   }
   
   //회원 목록 보기
   @GetMapping("/memberList")
   @PreAuthorize("isAuthenticated()")
   public String getMemberList(Model model) {
      List<MemberVO> memberList = service.getMemberList();
      model.addAttribute("memberList", memberList);
      return "/member/memberList";
   }
   
   //회원 상세 보기
   @GetMapping("/memberView")
   public String getMember(String userid, Model model) {
      MemberVO member = service.read(userid);
      model.addAttribute("member", member);
      
      return "/member/memberView";
   }
   
   //회원 삭제
   @GetMapping("/delete")
   public String delete(MemberVO member) {
      service.delete(member);
      return "redirect:/";
   }
   
   //회원 수정
   @PostMapping("/update")
   public String update(MemberVO member) {
      //비밀번호 암호화
      String encPw = pwencoder.encode(member.getUserpw());
         member.setUserpw(encPw);
         
      service.update(member);
      return "redirect:/member/memberList";
   }
}