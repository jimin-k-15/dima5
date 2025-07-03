package net.dima.spring5.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/display")
public class ConditionController {

	@GetMapping("/condition")
	public String condition(Model model) {
		// Iterable data
		List<String> fruit = Arrays.asList("복숭아","오렌지","무화과","메론","체리");
		
		List<Integer> number = new ArrayList<>();
		for(int i=1; i<=20; ++i)
			number.add(i*3);
			
		model.addAttribute("fruit", fruit);
		model.addAttribute("number", number);
		
		return "display/condition";   // forwarding		
	}
}
