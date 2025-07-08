package net.dima.spring8.dto;

public record UserRecord(
		String userId,
		String userPwd,
		String userName
	) {
}
