package net.dima.spring8.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dima.spring8.dto.LoginUserDetails;
import net.dima.spring8.entity.UserEntity;
import net.dima.spring8.repository.UserRepository;

// Security 가 제공하는 로그인 전용 Service 클래스 
@Service
@RequiredArgsConstructor
@Slf4j
public class LoginUserDetailsService implements UserDetailsService {
	private final UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String userId)  
			throws UsernameNotFoundException {
		
		// repository.findById(null);  // PK key 값을 달라는 요청(사용불가)
		// userId userPwd가 같아야 로그인
		UserEntity userEntity = repository.findByUserId(userId);
		if(userEntity != null) {
			// userEntity를 UserDetails를 상속받은 Resp로 변환해서 반환
			LoginUserDetails resp = LoginUserDetails.toResp(userEntity);
			return resp;
		} else {
			throw new UsernameNotFoundException("로그인 에러");
		}		
	}
}
