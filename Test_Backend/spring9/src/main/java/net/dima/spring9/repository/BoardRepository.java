package net.dima.spring9.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import net.dima.spring9.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

	// 2단계) 검색어를 이용한 조회 
	// List<BoardEntity> findByBoardTitleContains(String searchWord, Sort by);
	// List<BoardEntity> findByBoardWriterContains(String searchWord, Sort by);
	// List<BoardEntity> findByBoardContentContains(String searchWord, Sort by);
	
	// 3단계) 검색어 + 페이징
	Page<BoardEntity> findByBoardTitleContains(String searchWord, PageRequest of);
	Page<BoardEntity> findByBoardWriterContains(String searchWord, PageRequest of);
	Page<BoardEntity> findByBoardContentContains(String searchWord, PageRequest of);

}
