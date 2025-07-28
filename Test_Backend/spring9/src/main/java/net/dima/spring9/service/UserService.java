package net.dima.spring9.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dima.spring9.dto.UserDTO;
import net.dima.spring9.entity.UserEntity;
import net.dima.spring9.repository.UserRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
	private final UserRepository repository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/**
	 * 회원가입 처리
	 * @param userDTO
	 */
	public boolean joinProc(UserDTO userDTO) {
		boolean isExistUser = repository.existsById(userDTO.getUserId());
		if(isExistUser) return false; 
		
		// 비밀번호를 암호화하여 다시 세팅
		userDTO.setUserPwd(bCryptPasswordEncoder.encode(userDTO.getUserPwd()));  
		
		// dto -> entity 로 수정
		UserEntity userEntity = UserEntity.toEntity(userDTO);
		repository.save(userEntity);	// 가입 성공
		return true;
		
	}

	/**
	 * 전달받은 userId에 해당하는 사용자 정보를 조회
	 * @param userId
	 * @return
	 */
	public UserDTO selectOne(String userId) {
		Optional<UserEntity> temp = repository.findById(userId);
		UserDTO dto = null;
		
		if(temp.isPresent()) {
			dto = UserDTO.toDTO(temp.get());
		}
		
		return dto;
	}
}
