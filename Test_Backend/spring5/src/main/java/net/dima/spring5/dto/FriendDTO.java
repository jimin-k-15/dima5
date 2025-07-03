package net.dima.spring5.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendDTO {
	private String name;
	private int age;
	private String phone;
	private LocalDate birthday;
	private boolean active;
}
