package net.dima.test4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Maincontroller {
	
	@GetMapping("/")
	public String index() {
		return "index";  
	}
}
