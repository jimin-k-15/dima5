package net.dima.spring4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.dima.spring4.dto.FitnessRecord;

@Controller
public class FitnessController {
	
	@GetMapping("/fitness/fitnessInsert")
	public String fitnessInsert() {
		return "fitnessInsert";
	}
	
	@PostMapping("/fitness/fitnessInsert")
	public String fitnessInsert(@ModelAttribute FitnessRecord record, Model model) {
		double bmi = record.weight() / (record.height() * record.height() * 0.001) ;
		double stdWeight;
		double temp = record.height() / 100;
		
		if(record.gender().equals("남자"))
			stdWeight = temp * temp * 22;
		else
			stdWeight = temp * temp * 21;
		
		model.addAttribute("dto", record);
		model.addAttribute("bmi", bmi);
		model.addAttribute("stdweight", stdWeight);
		
		return "fitnessResult";
	}
}
