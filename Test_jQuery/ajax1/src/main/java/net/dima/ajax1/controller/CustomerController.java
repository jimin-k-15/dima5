package net.dima.ajax1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import net.dima.ajax1.dto.CustomerDTO;
import net.dima.ajax1.service.CustomerService;

@Controller
@RequiredArgsConstructor
public class CustomerController {
	private final CustomerService service;
	
	// 화면 전환 요청
	@GetMapping("/customer")
	public String customer() {
		return "customer";   // forwarding
	}
	
	public void insert(CustomerDTO dto) {
		
	}
	
	public List<CustomerDTO> selectAll() {
		return null;
	}
	
	public void delete(Integer seq) {
		
	}
}
