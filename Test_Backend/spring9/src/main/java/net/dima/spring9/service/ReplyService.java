package net.dima.spring9.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.dima.spring9.dto.ReplyDTO;
import net.dima.spring9.entity.BoardEntity;
import net.dima.spring9.entity.ReplyEntity;
import net.dima.spring9.repository.BoardRepository;
import net.dima.spring9.repository.ReplyRepository;

@Service
@RequiredArgsConstructor
public class ReplyService {
	private final BoardRepository boardRepository;
	private final ReplyRepository replyRepository;
	
	/**
	 * 특정한 게시글 번호의 댓글을 모두 조회
	 * @param boardSeq
	 * @return
	 */
	public List<ReplyDTO> selectAll(Long boardSeq) {
		// Board에 대한 정보를 먼저 조회
		Optional<BoardEntity> temp = boardRepository.findById(boardSeq);
		
		// 쿼리메소드 : 만들기 어렵고, 직관적이지 않다 
		// 네이티브 쿼리 : JPA 정책에 위반된다! --> QueryDSL 
		List<ReplyEntity> replyEntityList
			= replyRepository.findAllByBoardEntityOrderByReplySeqDesc(temp);
		
		List<ReplyDTO> list = new ArrayList<>();
		
		// ReplyEntity --> ReplyDTO로 변환
		replyEntityList.forEach((entity) -> list.add(ReplyDTO.toDTO(entity)));
		
		return list;
	}

	/**
	 * 댓글 저장
	 * @param replyDTO
	 */
	public void insertReply(ReplyDTO replyDTO) {
		// 1) 부모글이 있는지 조회
		Optional<BoardEntity> temp = boardRepository.findById(replyDTO.getBoardSeq());
		if(!temp.isPresent()) return;
		
		// 2) 부모글이 존재하면 부모글과 댓글 2개를 전달해서 Entity로 변환
		ReplyEntity replyEntity = ReplyEntity.toEntity(replyDTO, temp.get());
		
		// 3) DB에 댓글 저장
		replyRepository.save(replyEntity);
		
	}

	/**
	 * 댓글 삭제
	 * @param replySeq
	 */
	public void deleteReply(Integer replySeq) {
		Optional<ReplyEntity> temp = replyRepository.findById(replySeq);
		
		if(temp.isPresent()) {
			replyRepository.deleteById(replySeq);
		}
	}

	/**
	 * 댓글 조회
	 * @param replySeq
	 * @return
	 */
	public ReplyDTO selectReply(Integer replySeq) {
		Optional<ReplyEntity> temp = replyRepository.findById(replySeq);
		ReplyDTO dto = null;
		
		if(temp.isPresent()) {
			ReplyEntity entity = temp.get();
			dto = ReplyDTO.toDTO(entity);
		}
		return dto;
	}

	/**
	 * 전달받은 댓글을 DB에서 수정
	 * @param replySeq
	 * @param replyContent
	 */
	@Transactional
	public void updateReply(Integer replySeq, String replyContent) {
		Optional<ReplyEntity> temp = replyRepository.findById(replySeq);
		
		if(temp.isPresent()) {
			temp.get().setReplyContent(replyContent);
		}
	}
}
