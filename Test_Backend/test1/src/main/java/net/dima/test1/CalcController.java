package net.dima.test1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {

	@GetMapping("/calc")
	public String calc(
			@RequestParam(name="x") int x
			, @RequestParam(name="y") int y
			, Model model) {
		
		System.out.printf("%d, %d ", x, y);
		
		model.addAttribute("x", x);  // "x": 클라이언트가 뽑아서 쓸 값, x: 내가 보내는 값
		model.addAttribute("y", y);  
		model.addAttribute("result", x+y);  
		
		return "calcResult";
	}
	
}
