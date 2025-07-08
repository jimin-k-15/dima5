package net.dima.spring8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dima.spring8.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	// 사용자 정의 쿼리 메소드
	UserEntity findByUserId(String userId);

}
