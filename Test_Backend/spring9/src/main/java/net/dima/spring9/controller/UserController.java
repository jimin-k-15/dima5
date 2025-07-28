package net.dima.spring9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dima.spring9.dto.UserDTO;
import net.dima.spring9.service.UserService;

@Controller
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	
	
	/**
	 * 1) 로그인 화면 요청 : required = false
	 * 2) 아이디나 비번을 잘못 요청할 경우, LoginFailureHandler가 가로채서 이리로 보냄
	 * @return
	 */
	@GetMapping("/login")
	public String login(
			@RequestParam(name="error", required = false) boolean error,
			@RequestParam(name="errMessage", required = false) String errMessage,
			HttpServletRequest request,
			Model model
			) {
		model.addAttribute("error", error);
		model.addAttribute("errMessage", errMessage);	// 핸들러가 처리해서 보낸 메시지
		
		String refererUrl = request.getHeader("Referer");
		
		// 1) 로그인을 요청한 이전 페이지를 session 에 저장
		//    아이디나 비번을 잘못 입력해서 다시 접근하는 경우가 아니어야 하며
		//    이미 저장된 refererUrl 값에 login 이 포함되지 않아야 한다.
		
		HttpSession session = request.getSession();
		
		if(refererUrl != null)
		if(!error && !refererUrl.contains("login")) {
			session.setAttribute("refererUrl", refererUrl);
			log.info("{}", refererUrl);
			System.out.println("login 함수 내: " + refererUrl);
		}
		
		return "user/login";
	}

	/**
	 * 회원가입 화면 요청
	 * @return
	 */
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
	/**
	 * 회원가입 처리 요청
	 * @param userDTO
	 * @return
	 */
	@PostMapping("/joinProc")
	public String joinProc(@ModelAttribute UserDTO userDTO) {
		log.info("회원정보: {}", userDTO.toString());
		userService.joinProc(userDTO);
		
		return "redirect:/";
	}
	
	/**
	 * 중복아이디가 존재하는지 확인 (Ajax 처리)
	 * @return
	 */
	@ResponseBody
	@PostMapping("/confirmId")
	public boolean confirmId(@RequestParam(name="userId") String userId) {
		UserDTO dto = userService.selectOne(userId);	// abc
		
		if(dto == null) return true;
		return false;
	}
}
