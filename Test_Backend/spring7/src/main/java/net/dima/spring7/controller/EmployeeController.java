package net.dima.spring7.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import net.dima.spring7.dto.EmployeeResp;
import net.dima.spring7.service.EmployeeService;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService service;
	
	@GetMapping("/selectAll")
	public String selectAll(Model model) {
		List<EmployeeResp> list = service.selectAll();
		
		model.addAttribute("list", list);
		
		return "list";
	}
}
