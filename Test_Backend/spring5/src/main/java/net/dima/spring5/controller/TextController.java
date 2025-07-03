package net.dima.spring5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/display")
public class TextController {
	
	@GetMapping("/text")
	public String text(Model model) {
		// 문자열
		String korean = "대한민국!!! ☆★😁";
		String english = "English~~ 🎶🥨";
		String tag1 = "<marquee>돌이 굴러가유!</marquee>";
		String tag2 = "<marquee direction='right'>(❁´◡`❁)</marquee>";
		String url = "https://www.naver.com";
		
		// 비어있는 데이터
		String emptyData = "";
		String nullData = null;
		
		// 숫자 데이터
		int age = 25;
		double pi = Math.PI;
		boolean bool = true;
		
		model.addAttribute("korean", korean);
		model.addAttribute("english", english);
		model.addAttribute("tag1", tag1);
		model.addAttribute("tag2", tag2);
		model.addAttribute("url", url);
		model.addAttribute("emptyData", emptyData);
		model.addAttribute("nullData", nullData);
		model.addAttribute("age", age);
		model.addAttribute("pi", pi);
		model.addAttribute("bool", bool);
		
		return "display/text";
	}
}
