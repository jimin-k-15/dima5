package net.dima.jquery1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JQueryController {
	
	// 기본선택자 연습
	@GetMapping("/selector")
	public String selector() {
		return "selector";
	}
	
	// 필터선택자 연습
	@GetMapping("/filter")
	public String filter() {
		return "filter";
	}
	
	// 필터메소드 연습
	@GetMapping("/filter_method")
	public String filterMethod() {
		return "filter_method";
	}
	
	// DOM 조작 연습
	@GetMapping("/manipulation")
	public String manipulation() {
		return "manipulation";
	}
	
	// jQuery로 CSS에 접근해서 조작
	@GetMapping("/classTest")
	public String classTest() {
		return "classTest";
	}
	
	// prop를 이용해 상태값 처리
	@GetMapping("/exam1")
	public String exam1() {
		return "exam1";
	}
	
	// 동적으로 생성된 요소에 이벤트 입히기
	@GetMapping("/exam2")
	public String exam2() {
		return "exam2";
	}
	
	// 전송된 학력, 경력사항 받는 메소드
	@PostMapping("/resumeRegist")
	public String resumeRegist(
			@RequestParam(name="graduate") String[] graduate,
			@RequestParam(name="career") String[] career
			) {
		System.out.println(graduate.length + " / " + graduate[0]);
		System.out.println(career.length + " / " + career[0]);
		
		return "redirect:/"; 
	}
	
	// 회원가입 화면 요청
	@GetMapping("/memberJoin")
	public String memberJoin() {
		return "memberJoin";
	}
}
