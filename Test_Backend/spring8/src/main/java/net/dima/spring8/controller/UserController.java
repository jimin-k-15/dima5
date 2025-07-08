package net.dima.spring8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dima.spring8.dto.UserRecord;
import net.dima.spring8.service.UserService;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {
	private final UserService service;
	/**
	 * 회원가입 페이지 요청
	 * @return
	 */
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
	/**
	 * 회원가입 처리 요청
	 * @return
	 */
	@PostMapping("/joinProc")
	public String joinProc(@ModelAttribute UserRecord userRecord) {
		log.info("회원가입 정보: {}", userRecord.toString());
		service.joinProc(userRecord);
		
		return "redirect:/";
	}
	
	/**
	 * 로그인 화면 요청
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	// loginProc 요청은 Controller 에서 하지 않는다. 
	// 로그인만 단독으로 처리하는 서비스를 따로 만들어서 사용해야 함. 
	// 즉 (SecurityConfig), Service, LoginService 를 만들어서 해야 한다.
}
