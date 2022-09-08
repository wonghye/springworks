package com.cloud.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.domain.BoardVO2;
import com.cloud.service.BoardService2;

@RequestMapping("/board/*")  //localhost:8080/board/aaa
@Controller
public class BoardController2 {
   
   @Autowired
   private BoardService2 service2;

   //��� ����
   @GetMapping("/boardList2")//localhost:8080/board/boardList
   public String getBoardList2(Model model) {
      List<BoardVO2> boardList2 = service2.getBoardList2();
      model.addAttribute("boardList2", boardList2); //view�� ����
      
      return "/board/boardList2";
   }
   
   //�۾��� �� ������ ��û
   @PreAuthorize("isAuthenticated()")
   @GetMapping("/insertBoard2")
   public String insert2() {
      return "/board/insertBoard2";
   }
   
   //�۾��� ó�� ��û
   @PostMapping("/insertBoard2")
   @PreAuthorize("isAuthenticated()")
   public String insert2(BoardVO2 vo){
      service2.insert2(vo);      
      return "redirect:/board/boardList2";
   }
   
   //�� �󼼺��� ó��
   @GetMapping("/boardView2")
   public String getBoard2(int bno, Model model) {
      service2.updateCount2(bno);   //��ȸ�� ����
      BoardVO2 board2 = service2.getBoard2(bno); //�� ���� ó��
      model.addAttribute("board2", board2);  //model="board" ������
      return "/board/boardView2";
   }
   
   //�� ����
   @GetMapping("/deleteBoard2")
   public String delete2(BoardVO2 vo) {
      service2.delete2(vo);
      return "redirect:/board/boardList2";
   }
   
   //�� ����
   @PostMapping("/updateBoard2")
   public String update2(BoardVO2 vo) {
      service2.update2(vo);
      return "redirect:/board/boardList2";
   }
   
}