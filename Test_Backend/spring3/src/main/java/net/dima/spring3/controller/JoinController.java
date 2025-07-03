package net.dima.spring3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.dima.spring3.dto.User;

@Controller
public class JoinController {

	@PostMapping("/join")
	public String join(@ModelAttribute User user /* , Model model */) {
		// model.addAttribute("user", user);
		return "joinResult";
	}
}
