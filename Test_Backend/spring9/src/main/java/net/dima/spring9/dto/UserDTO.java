package net.dima.spring9.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dima.spring9.entity.UserEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
	private String userId;
	private String userName;
	private String userPwd;
	private String email;
	private String roles;
	private boolean enabled;
	
	public static UserDTO toDTO(UserEntity userEntity) {
		return UserDTO.builder()
				.userId(userEntity.getUserId())
				.userPwd(userEntity.getUserPwd())
				.userName(userEntity.getUserName())
				.email(userEntity.getEmail())
				.roles(userEntity.getRoles())
				.enabled(userEntity.isEnabled())
				.build();
	}
}

