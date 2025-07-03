package net.dima.spring3.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {
	private String userid;
	private String username;
	private String phone;
	private String email;
	private LocalDate birthday;
}
/*
아이디 : 문자열
이름 : 문자열
전화번호 : 문자열
이메일 : 문자열
생년월일 : 날짜
*/