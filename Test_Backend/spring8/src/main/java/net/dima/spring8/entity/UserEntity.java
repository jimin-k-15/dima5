package net.dima.spring8.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dima.spring8.dto.UserRecord;

@Entity
@Table(name="tbl_user")

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {
	@Id
	@Column(name="seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seq;
	
	@Column(name="user_id", unique = true)
	private String userId;
	
	@Column(name="user_pwd", nullable = false)
	private String userPwd;
	
	@Column(name="user_name", nullable = false)
	private String userName;
	
	@Builder.Default
	@ColumnDefault("ROLE_USER")
	@Column(name="role")
	private String role = "ROLE_USER";
	
	// record -> UserEntity
	public static UserEntity toEntity(UserRecord userRecord) {
		return UserEntity.builder()
				.userId(userRecord.userId())
				.userPwd(userRecord.userPwd())
				.userName(userRecord.userName())
				.build();
	}
}
