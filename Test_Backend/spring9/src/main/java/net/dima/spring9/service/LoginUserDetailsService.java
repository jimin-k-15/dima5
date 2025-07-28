package net.dima.spring9.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dima.spring9.dto.LoginUserDetails;
import net.dima.spring9.entity.UserEntity;
import net.dima.spring9.repository.UserRepository;

// Security 가 제공하는 로그인 전용 Service 클래스 
@Service
@RequiredArgsConstructor
@Slf4j
public class LoginUserDetailsService implements UserDetailsService {
	private final UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String userId)  
			throws UsernameNotFoundException {

		// userId userPwd가 같아야 로그인
		UserEntity temp = repository.findById(userId)
				.orElseThrow(() -> {
					throw new UsernameNotFoundException("존재하지 않는 아이디입니다.");
				});
		System.out.println(temp.toString());

		LoginUserDetails userDTO = LoginUserDetails.toDTO(temp);	
		return userDTO;
	}
}
