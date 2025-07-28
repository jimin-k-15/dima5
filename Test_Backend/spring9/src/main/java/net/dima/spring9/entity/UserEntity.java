package net.dima.spring9.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dima.spring9.dto.UserDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="boarduser")
public class UserEntity {
	@Id
	@Column(name="user_id")
	private String userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_pwd")
	private String userPwd;
	
	@Column(name="email")
	private String email;
	
	@Builder.Default
	private String roles="ROLE_USER";
	
	@Builder.Default
	private boolean enabled=true;
	
	public static UserEntity toEntity(UserDTO userDTO) {
		return UserEntity.builder()
				.userId(userDTO.getUserId())
				.userPwd(userDTO.getUserPwd())
				.userName(userDTO.getUserName())
				.email(userDTO.getEmail())
//				.roles(userDTO.getRoles())
//				.enabled(userDTO.isEnabled())
				.build();
	}
}