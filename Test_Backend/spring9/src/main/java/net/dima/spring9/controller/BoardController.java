package net.dima.spring9.controller;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dima.spring9.dto.BoardDTO;
import net.dima.spring9.dto.LoginUserDetails;
import net.dima.spring9.service.BoardService;
import net.dima.spring9.util.PageNavigator;

@Controller
@RequestMapping("/board")
@Slf4j
@RequiredArgsConstructor
public class BoardController {
	private final BoardService service;
	
	// pageLimit: 한 페이지에 보여줄 글 개수
	@Value("${user.board.pageLimit}") 
	int pageLimit; 	
	
	// 파일 저장 경로
	@Value("${spring.servlet.multipart.location}")
	String uploadPath;
	
	/**
	 * 1) index 에서 게시판을 요청 
	 * - searchItem, searchWord가 없는 상태로 목록 요청
	 * - 특정 페이지를 요청하지 않은 상태로 글목록 화면 요청 : DB에서 데이터를 조회하여 model 에 담은 후 Forwarding 
	 * 
	 * 2) 게시글 목록에서 다시 게시판을 요청 
	 * - searchItem, searchWord가 있는 상태로 목록 요청
	 * - 특정 페이지를 요청한 상태로 글목록 화면 요청
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/boardList")
	public String boardList(
			@AuthenticationPrincipal LoginUserDetails loginUser,
			@PageableDefault(page = 1) Pageable pageable, 		// 페이징을 도와주는 객체
			@RequestParam(name="searchItem", defaultValue="boardTitle") String searchItem,
			@RequestParam(name="searchWord", defaultValue="") String searchWord,
			Model model) {
		
		log.info("검색값 : {}, {}, 요청페이지: {}", searchItem, searchWord, pageable.getPageNumber());
		
		// DB에서 데이터 가져오기
		// List<BoardDTO> list = service.selectAll(); 	// 기본적인 요청
		// List<BoardDTO> list = service.selectAll(searchItem, searchWord);	// 검색 요청
		Page<BoardDTO> list = service.selectAll(pageable, searchItem, searchWord);	// 검색 + 페이징 
		
		int totalPages = list.getTotalPages();		// 전체 페이지 수
		int page = pageable.getPageNumber();		// 사용자가 요청한 페이지
		
		PageNavigator navi = new PageNavigator(pageLimit, page, totalPages);
		
		// 로그인을 한 경우
		if(loginUser != null) {
			model.addAttribute("loginName", loginUser.getUsername());
		}
		
		model.addAttribute("list", list);
		model.addAttribute("searchItem", searchItem);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("navi", navi);
		
		return "board/boardList";
	}
	
	/**
	 * 글쓰기 화면 요청 
	 * @return
	 */
	@GetMapping("/boardWrite")
	public String boardWrite() {
		return "board/boardWrite";
	}
	
	/**
	 * 글등록 요청 (DB에 저장) 
	 * 첨부파일이 있을 때 BoardDTO의 uploadFile 변수가 받음 =
	 * @return
	 */
	@PostMapping("/boardWrite")
	public String boardWrite(@ModelAttribute BoardDTO boardDTO) {
		service.insertBoard(boardDTO);
		
		return "redirect:/board/boardList";
	}
	
	/**
	 * 글 자세히 보기 + 조회수 1 증가 포함(service 단에서)
	 * @param boardSeq
	 * @param model
	 * @return
	 */
	@GetMapping("/boardDetail")
	public String boardDetail(
			@AuthenticationPrincipal LoginUserDetails loginUser,
			@RequestParam(name="boardSeq") Long boardSeq,
			@RequestParam(name="searchItem", defaultValue="boardTitle") String searchItem,
			@RequestParam(name="searchWord", defaultValue="") String searchWord
			, Model model
			) {
		
		BoardDTO boardDTO = service.selectOne(boardSeq);
		service.incrementHitcount(boardSeq);
		
		// 로그인을 한 경우
		if(loginUser != null) {
			model.addAttribute("loginName", loginUser.getUsername());
		}
		
		model.addAttribute("board", boardDTO);
		model.addAttribute("searchItem", searchItem);
		model.addAttribute("searchWord", searchWord);
		
		return "board/boardDetail";
	}
	
	/**
	 * 글삭제 
	 * @param boardSeq
	 * @return
	 */
	@GetMapping("/boardDelete")
	public String boardDelete(
			@RequestParam(name="boardSeq") Long boardSeq,
			@RequestParam(name="searchItem", defaultValue="boardTitle") String searchItem,
			@RequestParam(name="searchWord", defaultValue="boardTitle") String searchWord,
			RedirectAttributes rttr
			) {
			
		service.deleteOne(boardSeq);
		
		rttr.addAttribute("searchItem", searchItem);
		rttr.addAttribute("searchWord", searchWord);
		
		return "redirect:/board/boardList";
	}
	
	/**
	 * 글 수정을 위해 먼저 조회부터
	 * @param boardSeq
	 * @return
	 */
	@GetMapping("/boardUpdate")
	public String boardUpdate(
			@AuthenticationPrincipal LoginUserDetails loginUser,
			@RequestParam(name="boardSeq") Long boardSeq,
			@RequestParam(name="searchItem", defaultValue = "boardTitle") String searchItem,
	        @RequestParam(name="searchWord", defaultValue = "") String searchWord,
			Model model
			) {
		
		BoardDTO boardDTO = service.selectOne(boardSeq);
		
		// 로그인을 한 경우
		if(loginUser != null) {
			model.addAttribute("loginName", loginUser.getUsername());
		}
		
		model.addAttribute("board", boardDTO);
		model.addAttribute("searchItem", searchItem);     // 목록으로 돌아갈 때 이전상태 유지하기 위해 들고옴
	    model.addAttribute("searchWord", searchWord);
	
		return "board/boardUpdate";
	}
	
	/**
	 * 글수정 요청 (DB에 수정) 
	 * @return
	 */
	@PostMapping("/boardUpdate")
	public String boardUpdate(
			@ModelAttribute BoardDTO boardDTO,
			@RequestParam(name="searchItem", defaultValue = "boardTitle") String searchItem,
	        @RequestParam(name="searchWord", defaultValue = "") String searchWord,
	        RedirectAttributes rttr
	        ) {
		log.info("{}", boardDTO.toString());
		log.info("첨부된 파일명: {}", boardDTO.getUploadFile().getOriginalFilename());
		
		service.updateBoard(boardDTO);
		
		rttr.addAttribute("searchItem", searchItem);
		rttr.addAttribute("searchWord", searchWord);
		
		return "redirect:/board/boardList";
	}
	
	/**
	 * 특정 글의 첨부파일 다운로드
	 * @param boardSeq
	 * @return
	 */
	@GetMapping("/download")
	public String download(
			@RequestParam(name="boardSeq") Long boardSeq,
			HttpServletResponse response 			
			) {
		BoardDTO boardDTO = service.selectOne(boardSeq);
		String originalFilename = boardDTO.getOriginalFilename();
		String savedFileName = boardDTO.getSavedFilename();
		
		try {
			String tempName = URLEncoder.encode(
					originalFilename,
					StandardCharsets.UTF_8.toString());
			
			response.setHeader("Content-Disposition", "attachment;filename="+tempName);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String fullPath = uploadPath + "/" + savedFileName;
		
		// 스트림 설정 (실제 다운로드가 일어나는 구간)
		FileInputStream filein = null;
		ServletOutputStream fileout = null;
		
		try {
			filein = new FileInputStream(fullPath);
			fileout = response.getOutputStream();
			
			FileCopyUtils.copy(filein, fileout);
			
			fileout.close();
			filein.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
