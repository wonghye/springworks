package com.cloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/exam")
@RestController
public class ExController {
	
	//문자열 리턴하기
	@GetMapping(value="/getText", produces="text/plain; charset=utf-8")
	public String getText() { 	//produces 속성을 사용하여 한글 지원
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		return "안녕~ Rest";
	}
	
	
	//VO 객체 리턴하기
	@GetMapping(value="/getSample", produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(111, "잡스","스티브");
	}
	
	
	//collection(리스트) 리턴하기
	@GetMapping("/getList")
	public List<SampleVO> getList(){
		return IntStream.range(1, 10)
						.mapToObj(i -> new SampleVO(i, i+"First", i + "Last"))
						.collect(Collectors.toList());		
	}
	
		
	  //collection(map) 리턴하기
	  @GetMapping("/getMap") 
	  public Map<String, SampleVO> getMap(){ 
		  Map<String,SampleVO> map = new HashMap<>(); 
		  map.put("First", new SampleVO(112,"Bill","gates")); 
		  return map; 
	  }
	
	//@PathVariable
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, 
							@PathVariable("pid") String pid) {
		return new String[] {"category: " + cat, "prouctid " + pid};
	}
	
	
	//@RequestBody - 전달된 내용을 이용해서 해당 파라미터의 타입으로 변환을 요청
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert.. ticket" + ticket);
		return ticket;
	}
	
	
	  
}
