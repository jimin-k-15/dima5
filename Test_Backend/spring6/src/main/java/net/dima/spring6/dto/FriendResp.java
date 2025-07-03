package net.dima.spring6.dto; 

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dima.spring6.entity.FriendEntity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//출력용 DTO (클라이언트에게 보내줄 때 사용)
public class FriendResp {
	private Integer id;   
	private String name;
	private int age;
	private LocalDate birthday;
	private String phone;
	private boolean active;
	
	public static FriendResp toFriendResp(FriendEntity entity) {
		return FriendResp.builder()
				.id(entity.getId())
				.name(entity.getName())
				.age(entity.getAge())
				.birthday(entity.getBirthday())
				.phone(entity.getPhone())
				.active(entity.isActive())
				.build();						
	}
}
