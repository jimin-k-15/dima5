package net.dima.spring6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dima.spring6.entity.FriendEntity;

public interface FriendRepository extends JpaRepository<FriendEntity, Integer>{
	// <Entity 객체, 그 Entity 객체의 primary key의 타입>
}
