package net.dima.ajax1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dima.ajax1.dto.CustomerDTO;
import net.dima.ajax1.service.CustomerService;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CustomerController {
	private final CustomerService service;
	
	// 화면 전환 요청
	@GetMapping("/customer")
	public String customer() {
		return "customer";   // forwarding
	}
	
	@PostMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute CustomerDTO dto) {
		// log.info("{}", dto.toString()); // 확인용
		
		service.insert(dto);
		return "success"; 
	}
	
	@GetMapping("/selectAll")
	@ResponseBody
	public List<CustomerDTO> selectAll() {
		List<CustomerDTO> list = service.selectAll();
		
		return list;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam(name="seq") Integer seq) {
		service.delete(seq);
		
		return "success";
	}
}
