package net.dima.spring8.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dima.spring8.entity.UserEntity;

// 로그인 전용 DTO (응답용. 요청을 받을 때는 record)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginUserDetails implements UserDetails {
	
	private String userId;
	private String userPwd;
	private String userName;
	private String roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(roles));
	}

	@Override
	public String getPassword() {
		return userPwd;
	}

	@Override
	// 로그인할 때 필요한 아이디
	public String getUsername() {
		return userId;
	}
	
	// 사용자 정의 메소드 (실명)
	public String getUserName() {
		return userName; 
	}
	
	// Entity --> Resp
	public static LoginUserDetails toResp(UserEntity entity) {
		return LoginUserDetails.builder()
				.userId(entity.getUserId())
				.userPwd(entity.getUserPwd())
				.userName(entity.getUserName())
				.roles(entity.getRole())
				.build();
	}
}
