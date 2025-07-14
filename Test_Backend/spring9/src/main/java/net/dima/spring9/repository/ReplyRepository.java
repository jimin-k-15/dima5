package net.dima.spring9.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dima.spring9.entity.BoardEntity;
import net.dima.spring9.entity.ReplyEntity;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {

	List<ReplyEntity> findAllByBoardEntityOrderByReplySeqDesc(Optional<BoardEntity> temp);
	
}
