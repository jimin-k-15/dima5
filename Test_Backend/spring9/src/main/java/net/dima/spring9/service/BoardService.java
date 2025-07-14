package net.dima.spring9.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dima.spring9.dto.BoardDTO;
import net.dima.spring9.entity.BoardEntity;
import net.dima.spring9.repository.BoardRepository;
import net.dima.spring9.util.FileService;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository repository;
	
	// 글 개수
	@Value("${user.board.pageLimit}") 
	int pageLimit; 	
	
	// 파일 저장 경로
	@Value("${spring.servlet.multipart.location}")
	String uploadPath;

	/**
	 * 1) 단순 조회
	 * 2) 검색어를 이용한 조회 추가
	 * 3) 검색기능 + 페이징
	 * @param pageable 
	 * @param searchItem
	 * @param searchWord
	 * @return
	 */
	public Page<BoardDTO> selectAll(Pageable pageable, String searchItem, String searchWord) {
		// 3) 페이징을 위한 사전 작업
		// 아래에서 -1을 하는 이유: 사용자가 1페이지를 요청하면 DB에서는 0페이지를 가져와야 함
		int page = pageable.getPageNumber()-1;
		
		// 3단계) 검색어 + 페이징을 이용한 조회
		Page<BoardEntity> temp = null;
		Page<BoardDTO> list = null;
		
		switch(searchItem) {
		case "boardTitle":
//			temp = repository.findByBoardTitleContains(searchWord, Sort.by(Sort.DEFAULT_DIRECTION.DESC, "boardSeq"));
			temp = repository.findByBoardTitleContains(
					searchWord, 
					PageRequest.of(page, pageLimit, Sort.by(Sort.DEFAULT_DIRECTION.DESC, "boardSeq")));
			break;
			
		case "boardWriter":
			temp = repository.findByBoardWriterContains(
					searchWord, 
					PageRequest.of(page, pageLimit, Sort.by(Sort.DEFAULT_DIRECTION.DESC, "boardSeq")));
			break;
			
		case "boardContent":
			temp = repository.findByBoardContentContains(
					searchWord, 
					PageRequest.of(page, pageLimit, Sort.by(Sort.DEFAULT_DIRECTION.DESC, "boardSeq")));
			break;
		}
		
		// BoardDTO에 생성자 추가: Paging 으로 인해 작성한 코드
		list = temp.map((board) -> new BoardDTO(
				board.getBoardSeq(),
				board.getBoardWriter(),
				board.getBoardTitle(),
				board.getHitCount(),
				board.getCreateDate(),
				board.getOriginalFilename()
		));
		
		// temp.forEach((entity) -> list.add(BoardDTO.toDTO(entity)));
		
		// 1) 전체 글 단순 조회
		// List<BoardEntity> temp = repository.findAll(Sort.by(Sort.DEFAULT_DIRECTION.DESC, "boardSeq"));
		// List<BoardDTO> list = new ArrayList<>();
		
		// temp.forEach((entity) -> list.add(BoardDTO.toDTO(entity)));
		
		return list;
	}

	/**
	 * 글 등록
	 * @param boardDTO
	 */
	public void insertBoard(BoardDTO boardDTO) {
		String originalFilename = null;
		String savedFilename = null;
		
		// 첨부파일이 있는 경우 파일명 세팅 실시
		if(!boardDTO.getUploadFile().isEmpty()) {
			originalFilename = boardDTO.getUploadFile().getOriginalFilename();
			savedFilename = FileService.saveFile(boardDTO.getUploadFile(), uploadPath);
			
			boardDTO.setOriginalFilename(originalFilename);
			boardDTO.setSavedFilename(savedFilename);
		}
		
		BoardEntity boardEntity = BoardEntity.toEntity(boardDTO);
		
		repository.save(boardEntity);
	}
	
	
	/**
	 * 글 1개 조회하고 조회수를 1 증가(수정) -> 아래 코드와 두 파트로 분리
	 * @param boardSeq
	 * @return
	 */
	public BoardDTO selectOne(Long boardSeq) {
		Optional<BoardEntity> temp = repository.findById(boardSeq);
		
		BoardDTO boardDTO = null;
		
		if(temp.isPresent()) {
			BoardEntity entity = temp.get();
			boardDTO = BoardDTO.toDTO(entity);
		}
		
		return boardDTO;
	}
	
	/**
	 * 글 1개 조회하고 조회수를 1 증가(수정) -> 위 코드와 두 파트로 분리
	 * @param boardSeq
	 * @return
	 */
	@Transactional
	public void incrementHitcount(Long boardSeq) {
		Optional<BoardEntity> temp = repository.findById(boardSeq);
		
		if(temp.isPresent()) {
			BoardEntity entity = temp.get();
			entity.setHitCount(entity.getHitCount() + 1);	// 조회수 1 증가
		}
	}
	
	/**
	 * DB에서 글 1개 삭제
	 * 삭제하기 전에 해당 글이 존재하는지 여부 확인 
	 * @param boardSeq
	 */
	public void deleteOne(Long boardSeq) {
		Optional<BoardEntity> temp = repository.findById(boardSeq);
		
		if(temp.isPresent()) {
			repository.deleteById(boardSeq);
		}
	}

	/**
	 * 전달받은 글을 수정함 (@Transactional 꼭 넣기) 
	 * @param boardDTO
	 */
	@Transactional
	public void updateBoard(BoardDTO boardDTO) {
		// 글 번호를 이용해 조회한 후 setting
		Long boardSeq = boardDTO.getBoardSeq();
		
		Optional<BoardEntity> temp = repository.findById(boardSeq);
		
		if(temp.isPresent()) {
			BoardEntity entity = temp.get();
			entity.setBoardTitle(boardDTO.getBoardTitle());
			entity.setBoardContent(boardDTO.getBoardContent());
		}
	}
}
