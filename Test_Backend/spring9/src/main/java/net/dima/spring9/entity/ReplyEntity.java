package net.dima.spring9.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dima.spring9.dto.ReplyDTO;

@Entity
@Table(name="reply")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reply_seq")
	private Integer replySeq;
	
	/* 
	 * Board:Reply => 1:다 
	 * */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="board_seq")
	private BoardEntity boardEntity;		// FK
	
	@Column(name="reply_writer")
	private String replyWriter;
	
	@Column(name="reply_Content")
	private String replyContent;
	
	@Column(name="create_date")
	@CreationTimestamp		
	private LocalDateTime createDate;
	
	public static ReplyEntity toEntity(ReplyDTO replyDTO, BoardEntity boardEntity) {
		return ReplyEntity.builder()
				.replySeq(replyDTO.getReplySeq())
				.boardEntity(boardEntity)
				.replyWriter(replyDTO.getReplyWriter())
				.replyContent(replyDTO.getReplyContent())
				.createDate(replyDTO.getCreateDate())
				.build();
	}
}
