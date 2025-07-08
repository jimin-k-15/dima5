package net.dima.ajax1.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * @RestController 현재 클래스의 ** 모든 메소드의 반환이 @ResponseBody일 때 **
 * @ResponseBody를 삭제하고 대신 @Controller를 @RestController로 바꿔 사용 
 */
@RestController
public class AjaxController {
	
	@GetMapping("/ajaxReq1")
	@ResponseBody
	public String ajaxReq1() {
		return "Received Success"; 	// html 문서가 아니라 텍스트
	}
	
	@PostMapping("/ajaxReq2")
	@ResponseBody
	public Map<String, String> ajaxReq2(
			@RequestParam(name="username") String username,
			@RequestParam(name="phone") String phone
			) {
		// JSON으로 응답하려면 1) Map, 2) DTO
		Map<String, String> map = new HashMap<>();
		map.put("name", username+"님");
		map.put("phone", phone);
		
		return map;
	}
	
	@GetMapping("/ajaxReq3")
	@ResponseBody
	public List<String> ajaxReq3() {
		List<String> list = Arrays.asList("복숭아", "오렌지", "무화과", "체리", "살구");
		return list; 	
	}
}
	
