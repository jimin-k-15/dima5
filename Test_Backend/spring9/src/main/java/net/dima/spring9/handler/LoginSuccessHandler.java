package net.dima.spring9.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(
			HttpServletRequest request, 
			HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		List<String> roleNames = new ArrayList<>();
		
		// 한 명의 유저가 여러 Role 정보를 가질 수 있도록 처리
		authentication.getAuthorities().forEach((auth) -> 
			roleNames.add(auth.getAuthority()) );
		
		// 만약 roleNames의 정보 중에 ROLE_ADMIN이라면 admin 페이지로 이동하도록 설정할 수 있다.
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/admin.adminpage");
		}

		// Session: 인증된 사용자의 정보를 저장하는 메모리 공간
		HttpSession session = request.getSession();		
		String refererUrl = (String)session.getAttribute("refererUrl");
		
		log.info("로그인 성공: {}", refererUrl);
		
//		if(refererUrl != null) {
			response.sendRedirect(refererUrl);
//		} else {
			// 기본 URL로 redirection 
//			response.sendRedirect("/");
//		}
	}
}
