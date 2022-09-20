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
	
	//목록보기
	@GetMapping("/boardList") //localhost:8080/board/boardList
	public String getBoardList(Criteria cri, Model model) { 
		List<BoardVO> boardList = service.getListWithPage(cri);
		int total = service.getTotalCount(cri);
		PageDTO pageMaker = new PageDTO(cri, service.getTotalCount(cri));
		
		model.addAttribute("boardList", boardList);  // view 로 전송
		model.addAttribute("pageMaker", pageMaker); // "pageMaker" -> boardList
		return "/board/boardList";
	}
	
	//글쓰기 폼 페이지 요청
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/insertBoard")
	public String insert() {
		return "/board/insertBoard";
	}
	
	//글쓰기 처리 요청
	@PreAuthorize("isAuthenticated()") 
	@PostMapping("/insertBoard")
	public String insert(BoardVO vo, HttpServletRequest request) throws IllegalStateException, IOException {
		request.setCharacterEncoding("utf-8");
		//파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) { // 파일이 첨부되었다면
			String fileName = uploadFile.getOriginalFilename();  // 파일 이름
			String filePath = "C:/upload/";  // 파일의 실제 위치
			uploadFile.transferTo(new File(filePath + fileName));
		}
		service.insert(vo);
		return "redirect:/board/boardList";
	}
	
	//글 상세보기 처리 , 댓글 목록 
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/boardView")
	public String getBoard(int bno,Criteria cri,  Model model) {
		service.updateCount(bno);			 // 조회수 증가
		BoardVO board = service.getBoard(bno);// 상세 보기 처리
		List<ReplyVO> replyList = replyService.getReplyList(bno); // 댓글 목록 처리
		
		model.addAttribute("board", board);  // model = board 보내기
		model.addAttribute("cri", cri); 	//model =  cri 보내기
		model.addAttribute("replyList", replyList); //model -> replyList 
		return "board/boardView";
	}
	
	//글 삭제
	@GetMapping("/deleteBoard")
	public String delete(BoardVO vo, Criteria cri, RedirectAttributes rttr ) {
		service.delete(vo); // redirect attributes 사용
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		return "redirect:/board/boardList";
	}
	
	//글 수정
	@PostMapping("/updateBoard")
	public String update(BoardVO vo, Criteria cri, RedirectAttributes rttr) {	
		service.update(vo);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		return "redirect:/board/boardList";
	}
	
	//댓글 등록
	@PostMapping("/reply")
	public String reply(ReplyVO vo, RedirectAttributes rttr) {
		log.info("댓글 작성");
		
		replyService.register(vo);  // 등록 처리 서비스
		
		rttr.addAttribute("bno", vo.getBno());
		return "redirect:/board/boardView";
	}
	
	
	//댓글 삭제 페이지 요청, 
		@GetMapping("/replyDelete")
		public String replyDeleteView(ReplyVO vo, Model model) {
			//해당 댓글 가져오기
			ReplyVO selectReply = replyService.getReply(vo.getRno());
			model.addAttribute("selectReply", selectReply);

			return "/board/replyDelete";
		}

		//댓글 삭제
		@PostMapping("/replyDelete")
		public String replyDelete(ReplyVO vo, 
				RedirectAttributes rttr) {
			replyService.delete(vo);
			//bno 보내줌
			rttr.addAttribute("bno", vo.getBno());
			return "redirect:/board/boardView";
		}

		//댓글 수정 페이지 요청, 
		@GetMapping("/replyUpdate")
		public String replyUpdateView(ReplyVO vo, Model model) {
			//해당 댓글 가져오기
			ReplyVO selectReply = replyService.getReply(vo.getRno());
			model.addAttribute("selectReply", selectReply);

			return "/board/replyUpdate";
		}

		//댓글 수정
		@PostMapping("/replyUpdate")
		public String replyUpdate(ReplyVO vo, 
				RedirectAttributes rttr) {
			replyService.update(vo);
			//bno 보내줌
			rttr.addAttribute("bno", vo.getBno());
			return "redirect:/board/boardView";
		}
	
}
