package net.dima.spring9.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dima.spring9.dto.BoardDTO;

@Entity
@Table(name="board")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="board_seq")
	private Long boardSeq;
	
	@Column(name="board_writer")
	private String boardWriter;
	
	@Column(name="board_title")
	private String boardTitle;
	
	@Column(name="board_content")
	private String boardContent;
	
	@Column(name="hit_count")
	private int hitCount;
	
	@Column(name="create_date")
	@CreationTimestamp		// default 로 설정된 글 등록 날짜를 현재 날짜로 세팅
	private LocalDateTime createDate;
	
	@Column(name="update_date")
	private LocalDateTime updateDate;
	
	@Column(name="original_filename")
	private String originalFilename;
	
	@Column(name="saved_filename")
	private String savedFilename;
	
	@OneToMany
	private List<ReplyEntity> entity;
	
	// 댓글 갯수 처리
	@Formula("(SELECT count(1) FROM reply r WHERE board_seq = r.board_seq)")
	private int replyCount;
	
	public static BoardEntity toEntity(BoardDTO boardDTO) {
		return BoardEntity.builder()
				.boardSeq(boardDTO.getBoardSeq())
				.boardWriter(boardDTO.getBoardWriter())
				.boardTitle(boardDTO.getBoardTitle())
				.boardContent(boardDTO.getBoardContent())
				.hitCount(boardDTO.getHitCount())
				.createDate(boardDTO.getCreateDate())
				.updateDate(boardDTO.getUpdateDate())
				.originalFilename(boardDTO.getOriginalFilename())
				.savedFilename(boardDTO.getSavedFilename())
				.build();
	}
}

