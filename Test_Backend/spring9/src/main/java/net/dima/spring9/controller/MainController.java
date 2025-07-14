package net.dima.spring9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	/**
	 * 첫 화면 요청
	 * @return
	 */
	@GetMapping({"/", ""})  // localhost:8080/	localhost:8080  -> /를 붙이든 안 붙이든 둘 다 하나의 요청으로 처리
	public String index() {
		return "index";  
	}
}
