package net.dima.spring9.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dima.spring9.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
