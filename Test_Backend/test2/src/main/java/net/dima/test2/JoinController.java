package net.dima.test2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoinController {
	
	@GetMapping("/join")
	public String join(
			@RequestParam(name="name") String name
			, @RequestParam(name="birthday") String birthday
			, @RequestParam(name="score") int score
			, Model model
			)  {
		// 450 : 골드 레벨
		// 300 : 실버 레벨
		// 200 : 브론즈 레벨
		// 200 이하 : 일반 레벨 
		String level = null;
		// 레벨 설정 : if문
		if(score >= 450)      level = "골드 레벨";
		else if(score >= 300) level = "실버 레벨";
		else if(score >= 200) level = "브론즈 레벨";
		else				  level = "일반 레벨";
		
		model.addAttribute("name", name);
		model.addAttribute("birthday", birthday);
		model.addAttribute("score", score);
		model.addAttribute("level", level); // 레벨을 모델에 저장
		
		return "join";
			}
}
