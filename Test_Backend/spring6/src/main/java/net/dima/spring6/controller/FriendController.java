package net.dima.spring6.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dima.spring6.dto.FriendDTO;
import net.dima.spring6.dto.FriendResp;
import net.dima.spring6.service.FriendService;

@Controller
@Slf4j
@RequiredArgsConstructor
public class FriendController {
	private final FriendService service;
	
	/**
	 * 친구 정보를 입력하기 위한 화면 요청
	 * @return
	 */
	@GetMapping("/regist")  
	public String regist() {
		return "friend/friendForm";
	}
	/**
	 * 친구 정보를 DB에 저장하기 위한 처리
	 * @param friendDTO
	 * @return
	 */
	@PostMapping("/regist")
	public String regist(@ModelAttribute FriendDTO friendDTO) {
		log.info("입력 정보 : {}", friendDTO.toString());
		
		service.regist(friendDTO);
		return "index";
	}
	
	/**
	 * 전체 정보 조회
	 * @param id
	 * @return
	 */
	@GetMapping("/selectAll")
	public String selectAll(Model model) {
		List<FriendResp> list = service.selectAll();
		
		model.addAttribute("list", list);
		return "friend/friendList";
	}
	
	/**
	 * 친구 데이터 삭제
	 * @param id
	 * @return
	 */
	@GetMapping("/delete")
	public String delete(@RequestParam(name="id") Integer id) {
		log.info("삭제할 아이디 : {}", id);
		
		service.delete(id);
		return "redirect:/selectAll";  // 삭제된 상태로 재조회
	}
	
	/**
	 * 수정을 위해 id의 값을 조회
	 * @param id
	 * @return
	 */
	@GetMapping("/update")
	public String update(@RequestParam(name="id") Integer id, Model model) {
		FriendResp friendResp = service.selectOne(id);
		
		model.addAttribute("friend", friendResp);
		return "friend/updateForm";
	}
	
	/**
	 * DB의 데이터를 수정
	 * @param dto
	 * @return
	 */
	@PostMapping("/update")
	public String update(@ModelAttribute FriendDTO dto) {
		log.info("수정 정보 : {}", dto.toString());
		
		service.update(dto);
		return "index";
	}
	

}
