package net.dima.spring9.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.dima.spring9.dto.LoginUserDetails;

@Controller
public class MainController {
	/**
	 * 첫 화면 요청 (로그인 성공하면 Controller 에서 정보를 얻어오도록) 
	 * @return
	 */
	@GetMapping({"/", ""})  // localhost:8080/	localhost:8080  -> /를 붙이든 안 붙이든 둘 다 하나의 요청으로 처리
	public String index(
			@AuthenticationPrincipal LoginUserDetails loginUser
			, Model model
			) {
		
		// 로그인을 한 경우
		if(loginUser != null) {
			model.addAttribute("loginName", loginUser.getUsername());
		}
		return "index";  
	}
}
