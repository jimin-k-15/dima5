package net.dima.spring9.dto;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dima.spring9.entity.BoardEntity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
	private Long boardSeq;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private int hitCount;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	private String originalFilename;
	private String savedFilename;
	
	public static BoardDTO toDTO(BoardEntity boardEntity) {
		return BoardDTO.builder()
				.boardSeq(boardEntity.getBoardSeq())
				.boardWriter(boardEntity.getBoardWriter())
				.boardTitle(boardEntity.getBoardTitle())
				.boardContent(boardEntity.getBoardContent())
				.hitCount(boardEntity.getHitCount())
				.createDate(boardEntity.getCreateDate())
				.updateDate(boardEntity.getUpdateDate())
				.originalFilename(boardEntity.getOriginalFilename())
				.savedFilename(boardEntity.getSavedFilename())
				.build();
	}

	
	// 파일 첨부되었을 때를 위한 추가작업
	private MultipartFile uploadFile;
	
	// 댓글의 갯수
	private int replyCount;
	
	// 생성자 추가 (Paging 을 위해 작성한 코드 + 이 값을 BoardList에 출력함)
	public BoardDTO(Long boardSeq, String boardWriter, String boardTitle, int hitCount, LocalDateTime createDate,
			String originalFilename, int replyCount) {
		this.boardSeq = boardSeq;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.hitCount = hitCount;
		this.createDate = createDate;
		this.originalFilename = originalFilename;
		this.replyCount = replyCount;
	}
}

