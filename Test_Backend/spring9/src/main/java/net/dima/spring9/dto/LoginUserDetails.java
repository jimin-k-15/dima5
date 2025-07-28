package net.dima.spring9.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dima.spring9.entity.UserEntity;

// 로그인 전용 DTO (응답용. 요청을 받을 때는 record)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private String roles;
	private Boolean enabled;

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
	
	// 필요하진 않지만 한번 해봄
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	// Entity --> DTO
	public static LoginUserDetails toDTO(UserEntity entity) {
		return LoginUserDetails.builder()
				.userId(entity.getUserId())
				.userPwd(entity.getUserPwd())
				.userName(entity.getUserName())
				.email(entity.getEmail())
				.roles(entity.getRoles())
				.build();
	}
}
