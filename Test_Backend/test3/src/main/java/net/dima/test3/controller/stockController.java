package net.dima.test3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.dima.test3.dto.Product;

@Controller
public class stockController {
	/**
	 * 재고사항 입력화면 요청
	 * @return
	 */
	@GetMapping("/stockInsert")
	public String stockInsert() {
		return "stockInsert";
	}
	
	/**
	 * 재고 입력 내용 처리 요청
	 * @param product
	 * @return
	 */
	@PostMapping("/stockProc")
	public String stockProc(@ModelAttribute Product product) {
		
		return "stockResult";
	}
}
