package net.dima.spring5.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.dima.spring5.dto.FriendDTO;

@Controller
@RequestMapping("/display")
public class ObjectController {
	@GetMapping("/object")
	public String object(Model model) {
		FriendDTO friend = new FriendDTO("전우치", 28, "010-1234-5678", LocalDate.of(1998, 11, 11), true);
		
		List<FriendDTO> fList = Arrays.asList(
				new FriendDTO("손오공", 30, "010-1234-5678", LocalDate.of(1996, 5, 26), false)
				, new FriendDTO("사오정", 25, "010-2310-1245", LocalDate.of(2001, 12, 26), true)
				, new FriendDTO("저팔계", 27, "010-6454-5678", LocalDate.of(1999, 1, 16), true)
				, new FriendDTO("이몽룡", 31, "010-7576-3441", LocalDate.of(1995, 7, 9), false)
				, new FriendDTO("임꺽정", 24, "010-5805-5724", LocalDate.of(2002, 4, 5), true)
				);
		model.addAttribute("friend", friend);
		model.addAttribute("fList", fList);
		
		return "display/object";
	}
}
