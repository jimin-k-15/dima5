package net.dima.spring8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration		// 이 파일이 설정파일임을 알려주는 annotation
@EnableWebSecurity	// 이 웹프로젝트가 Spring Security 로 관리됨을 알려주는 annotation 
public class SecurityConfig {

	@Bean 	// 반환되는 값을 bean 으로 등록 
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((auth) -> 
			auth.requestMatchers( 
					"/"
					, "/login"
					, "/join"
					, "/joinProc"
					, "/images/**" // images 하위 디렉토리에 있으면 전부 접근 가능
					, "/js/**"
					, "/css/**").permitAll()  // 로그인 없이 접근할 수 있는 경로 
			.requestMatchers("/admin").hasRole("ADMIN")
			.requestMatchers("/manager").hasRole("MANAGER")
			.requestMatchers("/my/**").hasAnyRole("ADMIN", "MANAGER", "USER")
			.anyRequest().authenticated()  	  // 항상 가장 마지막에. 기타 다른 경로는 로그인해야 접근 가능
			);
		
		// security 가 제공하는 기본 폼을 사용하지 않고, 개발자가 만든 폼 사용
		http
			.formLogin((auth) -> auth
				.loginPage("/login")				// 로그인 없이 특정 페이지에 접속을 시도하면 무조건 로그인 페이지로 redirect 
				.loginProcessingUrl("/loginProc")	// 로그인 화면에서 로그인 버튼을 클릭하면 Security 가 받아서 처리하는 경로 (Controller 에서는 처리하지 않음)
				.usernameParameter("userId")		// Security 가 사용하는 parameter 대신 개발자가 설정한 parameter 를 사용
				.passwordParameter("userPwd")		
				.defaultSuccessUrl("/")
				.failureUrl("/login?error=true")
				.permitAll()
					);
		
		// 로그아웃에 대한 처리
		http
			.logout((auth) -> auth
				.logoutUrl("/logout")				// 로그아웃 요청 URL
				.logoutSuccessUrl("/")				// 로그아웃 성공 시 URL
				.invalidateHttpSession(true) 		// 세션을 무효화
					);
		
		// Post 는 무조건 토큰을 전달해야 함. disabled 시키면 토큰 전달할 필요 없음
		// Security 는 사이트 위변조를 방어하도록 설정되어 있음
		// 개발할 때는 위변조 방어(CSRF)를 disable 하고 배포할 때 enabled 시킴
		http
			.csrf((auth) -> auth.disable());
		
		return http.build();
	}
	
	// 암호화 (비밀번호를 암호화)
	// 양방향(공개 key 암호화), 단방향(비밀 key 암호화)
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
