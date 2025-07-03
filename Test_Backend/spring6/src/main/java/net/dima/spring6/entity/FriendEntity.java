package net.dima.spring6.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.dima.spring6.dto.FriendDTO;

@Entity
@Table(name = "friend")
@Builder			 
@AllArgsConstructor // Builder와 함께 사용 
@NoArgsConstructor
@Setter
@Getter
@ToString
public class FriendEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;   // PK
	
	@Column(name = "name", length = 20, nullable = false)
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "birthday")
	private LocalDate birthday;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "active")
	private boolean active;
	
	// DTO를 받아서 Entity로 변경하는 Builder 패턴의 메소드 작성
	// 데이터베이스에 연동할 수 있는 형태는 Entity 객체뿐이기 때문
	public static FriendEntity toEntity(FriendDTO friendDTO) {
		return FriendEntity.builder()
				.id(friendDTO.id())
				.name(friendDTO.name())
				.age(friendDTO.age())
				.birthday(friendDTO.birthday())
				.phone(friendDTO.phone())
				.active(friendDTO.active())
				.build();
	}
}	

