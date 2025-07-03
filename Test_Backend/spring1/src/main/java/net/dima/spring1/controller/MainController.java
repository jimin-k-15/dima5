package net.dima.spring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")	// 주소 표시줄에서 요청하는 것은 Get 요청임
	public String index() {
		return "index";  // 파일명: src/main/resources/templates/index.html 의미
	}
}
