package net.dima.spring5.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import net.dima.spring5.dto.FriendDTO;

@Controller
@RequestMapping("/display")
public class MapController {

	@GetMapping("/mapData")
	public String mapData(Model model) {
		int age = 30;
		Map<String, FriendDTO> map = new HashMap<>();
		
		map.put("son", new FriendDTO("손오공", 25, "010-1111-2222", LocalDate.of(2000,12,25), true));
		map.put("saojung", new FriendDTO("사오정", 30, "010-2222-2222", LocalDate.of(2000,12,25), false));
		map.put("lee", new FriendDTO("이몽룡", 18, "010-3333-2222", LocalDate.of(2000,12,25), true));
		map.put("lim", new FriendDTO("임꺽정", 33, "010-4444-2222", LocalDate.of(2000,12,25), false));
		
		model.addAttribute("age", age);
		model.addAttribute("friend", map);
		
		return "display/mapData";
	}
	
	@GetMapping("/sendData")
	public String sendData(@ModelAttribute FriendDTO friendDTO) {
		System.out.println(friendDTO.toString());
		
		return "redirect:/display/mapData";   // forwarding(x), redirect(재호출을 하도록)
	}
}
