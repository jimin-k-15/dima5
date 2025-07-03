package net.dima.spring6.dto;

import java.time.LocalDate;

public record FriendDTO 
	(Integer id, String name, int age, String phone, LocalDate birthday, boolean active) 
	// setter, getter, tostring을 통해 데이터를 바꾸지 못하게 하려고
{
	// id : 첫 등록 시에는 없고, 수정 시에는 있고
	// 컴팩트 생성자
	public FriendDTO {
		if(id == null)
		id = 0;
	}
}
