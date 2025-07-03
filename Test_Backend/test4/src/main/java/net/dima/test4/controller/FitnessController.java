package net.dima.test4.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dima.test4.dto.FitnessRecord;
import net.dima.test4.dto.FitnessResp;
import net.dima.test4.service.FitnessService;

@Controller
@Slf4j
@RequestMapping("/fitness")
@RequiredArgsConstructor
public class FitnessController {
	private final FitnessService service;  // 반드시 final로 해야 함. 아니면 null이 됨
	
	
	/**
	 * 회원가입을 위한 화면 요청
	 * @return
	 */
	@GetMapping("/regist")
	public String regist() {
		return "fitness/insert";
	}
	
	/**
	 * 회원가입 처리 요청
	 * @param fitnessRecord
	 * @return
	 */
	@PostMapping("/regist")
	public String regist(@ModelAttribute FitnessRecord fitnessRecord) {
		log.info("가입정보: {}", fitnessRecord.toString());
		
		service.insert(fitnessRecord);
		return "redirect:/";
	}
	
	/**
	 * 전체 회원 정보 조회 요청
	 * @param model
	 * @return
	 */
	@GetMapping("/selectAll")
	public String selectAll(Model model) {
		List<FitnessResp> list = service.selectAll();
		model.addAttribute("list", list);
		
		return "fitness/list";
	}
	
	/**
	 * 한 명의 회원 정보 요청
	 * @param model
	 * @return
	 */
	@GetMapping("/selectOne")
	public String selectOne(@RequestParam(name="id") Integer id, Model model) {
		FitnessResp resp = service.selectOne(id);
		model.addAttribute("fitness", resp);
		
		return "fitness/detail";
	}
	
	/**
	 * 회원 데이터 삭제
	 * @param id
	 * @return
	 */
	@GetMapping("/delete")
	public String delete(@RequestParam(name="id") Integer id) {
		service.delete(id);
		
		return "redirect:/fitness/selectAll";
	}
	
	/**
	 * 회원 정보 수정 화면 요청
	 * @param model
	 * @return
	 */
	@GetMapping("/update")
	public String update(@RequestParam(name="id") Integer id, Model model) {
		FitnessResp resp = service.selectOne(id);
		
		model.addAttribute("fitness", resp);
		return "fitness/update";
	}
	
	/**
	 * 회원 정보 처리 요청
	 * @param model
	 * @return
	 */
	@PostMapping("/update")
	public String update(
			@RequestParam(name="id") Integer id,
			@RequestParam(name="height") double height,
			@RequestParam(name="weight") double weight) {
		service.update(id, height, weight);
	
		return "redirect:/fitness/selectAll";
	}
	
}
