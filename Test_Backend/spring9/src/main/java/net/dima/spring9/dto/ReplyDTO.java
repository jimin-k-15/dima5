package net.dima.spring9.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dima.spring9.entity.ReplyEntity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
	private Integer replySeq;
	private Long boardSeq;
	private String replyWriter;
	private String replyContent;
	private LocalDateTime createDate;
	
	public static ReplyDTO toDTO(ReplyEntity replyEntity) {
		return ReplyDTO.builder()
				.replySeq(replyEntity.getReplySeq())
				.boardSeq(replyEntity.getBoardEntity().getBoardSeq())
				.replyWriter(replyEntity.getReplyWriter())
				.replyContent(replyEntity.getReplyContent())
				.createDate(replyEntity.getCreateDate())
				.build();
	}
}
