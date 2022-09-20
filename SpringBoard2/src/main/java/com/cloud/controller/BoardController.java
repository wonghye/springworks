package com.cloud.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;
import com.cloud.domain.PageDTO;
import com.cloud.domain.ReplyVO;
import com.cloud.service.BoardService;
import com.cloud.service.ReplyService;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/board/*")  // localhost:8080/board/~~
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private ReplyService replyService;
	
	//��Ϻ���
	@GetMapping("/boardList") //localhost:8080/board/boardList
	public String getBoardList(Criteria cri, Model model) { 
		List<BoardVO> boardList = service.getListWithPage(cri);
		int total = service.getTotalCount(cri);
		PageDTO pageMaker = new PageDTO(cri, service.getTotalCount(cri));
		
		model.addAttribute("boardList", boardList);  // view �� ����
		model.addAttribute("pageMaker", pageMaker); // "pageMaker" -> boardList
		return "/board/boardList";
	}
	
	//�۾��� �� ������ ��û
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/insertBoard")
	public String insert() {
		return "/board/insertBoard";
	}
	
	//�۾��� ó�� ��û
	@PreAuthorize("isAuthenticated()") 
	@PostMapping("/insertBoard")
	public String insert(BoardVO vo, HttpServletRequest request) throws IllegalStateException, IOException {
		request.setCharacterEncoding("utf-8");
		//���� ���ε� ó��
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) { // ������ ÷�εǾ��ٸ�
			String fileName = uploadFile.getOriginalFilename();  // ���� �̸�
			String filePath = "C:/upload/";  // ������ ���� ��ġ
			uploadFile.transferTo(new File(filePath + fileName));
		}
		service.insert(vo);
		return "redirect:/board/boardList";
	}
	
	//�� �󼼺��� ó�� , ��� ��� 
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/boardView")
	public String getBoard(int bno,Criteria cri,  Model model) {
		service.updateCount(bno);			 // ��ȸ�� ����
		BoardVO board = service.getBoard(bno);// �� ���� ó��
		List<ReplyVO> replyList = replyService.getReplyList(bno); // ��� ��� ó��
		
		model.addAttribute("board", board);  // model = board ������
		model.addAttribute("cri", cri); 	//model =  cri ������
		model.addAttribute("replyList", replyList); //model -> replyList 
		return "board/boardView";
	}
	
	//�� ����
	@GetMapping("/deleteBoard")
	public String delete(BoardVO vo, Criteria cri, RedirectAttributes rttr ) {
		service.delete(vo); // redirect attributes ���
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		return "redirect:/board/boardList";
	}
	
	//�� ����
	@PostMapping("/updateBoard")
	public String update(BoardVO vo, Criteria cri, RedirectAttributes rttr) {	
		service.update(vo);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		return "redirect:/board/boardList";
	}
	
	//��� ���
	@PostMapping("/reply")
	public String reply(ReplyVO vo, RedirectAttributes rttr) {
		log.info("��� �ۼ�");
		
		replyService.register(vo);  // ��� ó�� ����
		
		rttr.addAttribute("bno", vo.getBno());
		return "redirect:/board/boardView";
	}
	
	
	//��� ���� ������ ��û, 
		@GetMapping("/replyDelete")
		public String replyDeleteView(ReplyVO vo, Model model) {
			//�ش� ��� ��������
			ReplyVO selectReply = replyService.getReply(vo.getRno());
			model.addAttribute("selectReply", selectReply);

			return "/board/replyDelete";
		}

		//��� ����
		@PostMapping("/replyDelete")
		public String replyDelete(ReplyVO vo, 
				RedirectAttributes rttr) {
			replyService.delete(vo);
			//bno ������
			rttr.addAttribute("bno", vo.getBno());
			return "redirect:/board/boardView";
		}

		//��� ���� ������ ��û, 
		@GetMapping("/replyUpdate")
		public String replyUpdateView(ReplyVO vo, Model model) {
			//�ش� ��� ��������
			ReplyVO selectReply = replyService.getReply(vo.getRno());
			model.addAttribute("selectReply", selectReply);

			return "/board/replyUpdate";
		}

		//��� ����
		@PostMapping("/replyUpdate")
		public String replyUpdate(ReplyVO vo, 
				RedirectAttributes rttr) {
			replyService.update(vo);
			//bno ������
			rttr.addAttribute("bno", vo.getBno());
			return "redirect:/board/boardView";
		}
	
}
