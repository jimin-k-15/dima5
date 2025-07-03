package net.dima.spring5.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/display")
public class FormatController {
	@GetMapping("/format")
	public String format(Model model) {
		// 숫자데이터
		int intNum = 1234567890;
		double doubleNum = 1234.567890;
		double percent = 0.0325;
		double money = 5678900;
		
		// 날짜데이터 (LocalData, LocalDateTime)
		LocalDate today = LocalDate.now();
		LocalDateTime now = LocalDateTime.now();
		
		model.addAttribute("intNum", intNum);
		model.addAttribute("doubleNum", doubleNum);
		model.addAttribute("percent", percent);
		model.addAttribute("money", money);
		model.addAttribute("today", today);
		model.addAttribute("now", now);
		
		return "display/format";
	}
}
