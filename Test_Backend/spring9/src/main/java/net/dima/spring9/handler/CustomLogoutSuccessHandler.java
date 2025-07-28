package net.dima.spring9.handler;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Authentication authentication) throws IOException, ServletException {
		
		// 로그아웃 후에 이전 페이지에 그대로 머물러 있기 위해 refererUrl 가져오기
		String refererUrl = request.getHeader("refererUrl");

		log.info("로그아웃 성공: {}", refererUrl);
		
		if(refererUrl != null) {
			response.sendRedirect(refererUrl);	// 로그아웃 하기 직전의 페이지로 redirect 
		} else {
			// 기본 URL로 redirection 
			response.sendRedirect("/");			// refererUrl이 없는 경우는 첫 페이지로 redirect 
		}
	}
}
