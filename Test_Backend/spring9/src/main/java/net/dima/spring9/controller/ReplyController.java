package net.dima.spring9.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dima.spring9.dto.ReplyDTO;
import net.dima.spring9.service.ReplyService;

@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
@Slf4j
public class ReplyController {
	
	private final ReplyService replyService;
	
	/**
	 * 특정 게시글(boardSeq)의 모든 댓글을 조회
	 * @param boardSeq
	 * @return
	 */
	@GetMapping("/replyAll")
	@ResponseBody
	public List<ReplyDTO> replyAll(@RequestParam(name="boardSeq") Long boardSeq) {
		List<ReplyDTO> replyList = replyService.selectAll(boardSeq);
		
		return replyList;
	}
	
	/**
	 * 특정 게시글(boardSeq)의 댓글을 저장
	 * @param replyDTO
	 */
	@PostMapping("/replyWrite")
	@ResponseBody
	public String replyWrite(@ModelAttribute ReplyDTO replyDTO) {
		log.info("{}", replyDTO.toString());
		
		replyService.insertReply(replyDTO);
		
		return "success";	// html 문서가 아님 
	}
	
	/**
	 * 댓글 삭제 
	 * @param replySeq
	 * @return
	 */
	@PostMapping("/replyDelete")
	@ResponseBody
	public String replyDelete(@RequestParam(name="replySeq") Integer replySeq) {
		log.info("{}", replySeq);
		
		replyService.deleteReply(replySeq);
		return "success";
	}
	
	/**
	 * 댓글 수정을 위한 조회 
	 * @param replySeq
	 * @return
	 */
	@GetMapping("/replyUpdate")
	@ResponseBody
	public ReplyDTO replyUpdate(@RequestParam(name="replySeq") Integer replySeq) {
		log.info("{}", replySeq);
		
		ReplyDTO replyDTO = replyService.selectReply(replySeq);
		
		return replyDTO;
	}
	
	/**
	 * 전송된 댓글 데이터를 DB에서 수정 처리
	 * @param replySeq
	 * @param replyContent
	 * @return
	 */
	@PostMapping("/replyUpdateProc")
	@ResponseBody
	public String replyUpdateProc(
			@RequestParam(name="replySeq") Integer replySeq,
			@RequestParam(name="replyContent") String replyContent
			) {
		log.info("{}", replySeq, replyContent);
		
		replyService.updateReply(replySeq, replyContent);
		
		return "success";
	}
}


