package net.dima.spring3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping(value="/")
	public String index() {
		return "index";   // src/main/resources/index.html
	}
}
