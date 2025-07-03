package net.dima.spring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BMIController {
	// <a href="/bmi?height=175&weight=65.7">
	@GetMapping("/bmi")
	public String bmi(
			@RequestParam(name="height") double height
			, @RequestParam(name="weight") double weight
			, Model model) {
		
		
		// 1) bmi (키를 m로 환산하여 bmi를 구한다.) 
		double h = height / 100;
		double bmi = weight / (h * h);
		
		// 2) 파라미터 자리에서 Model 객체를 Spring에게 요청한다.
		// 3) 클라이언트에게 응답할 키, 몸무게, bmi 결과를 model에 담는다.
		model.addAttribute("height", height);
		model.addAttribute("weight", weight);
		model.addAttribute("bmi", bmi);
		
		// 4) html 문서에서 응답받은 키, 몸무게, bmi를 타임리프로 출력한다.
		
		return "bmi_result";  // 응답한 파일명
	}
}
