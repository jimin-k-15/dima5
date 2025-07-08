package net.dima.spring8.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.dima.spring8.dto.UserRecord;
import net.dima.spring8.entity.UserEntity;
import net.dima.spring8.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository repository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void joinProc(UserRecord userRecord) {
		UserEntity temp = UserEntity.toEntity(userRecord);
		
		// 비밀번호 암호화한 후 raw data 상태인 비밀번호로 바꿔치기
		temp.setUserPwd(
				bCryptPasswordEncoder.encode(userRecord.userPwd()) );  // 암호화 완료
		
		repository.save(temp);
		
	}

}
