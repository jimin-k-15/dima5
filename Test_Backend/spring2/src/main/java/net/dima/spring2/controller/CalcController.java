package net.dima.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller   // 사용자의 요청을 받아들이는 Bean
public class CalcController {

	@PostMapping("/calc")
	public String calc(
		@RequestParam(name="x") int x
		, @RequestParam(name="y") int y
		, Model model 
		) {
		System.out.println(x + ", " + y);
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		model.addAttribute("result", x+y);
		
		return "calcResult";  // calcResult.html을 의미함
	}
}
