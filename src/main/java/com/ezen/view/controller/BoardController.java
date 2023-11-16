package com.ezen.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.biz.board.BoardService;
import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardListVO;
import com.ezen.biz.dto.BoardVO;

@Controller
@SessionAttributes("board")  // getBoard()에서 "board"속성으로 값을 저장하면 
							 // Session 객체에도 같이 값이 저장됨
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	// 게시글 등록
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {

		MultipartFile uploadFile = vo.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/Temp/upload/"+fileName));
		} else {
			System.out.println("파일 업로드가 정상적으로 처리되지 않았습니다.");
		}
		
		boardService.insertBoard(vo);

		// 3. 화면 네비게이션
		return "getBoardList.do";
	}
	
	// 게시글 수정
	// Session 객체에 저장된 board 속성의 값이 @ModelAttribute를 통하여 BoardVO 객체에 전달됨
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("게시글 수정 처리: <작성자 이름> " + vo.getWriter());
		
		boardService.updateBoard(vo);
		
		return "getBoardList.do";
	}
	
	// 게시글 삭제
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		
		return "getBoardList.do";			
	}
	
	// 상세 게시글 조회
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {

		BoardVO board = boardService.getBoard(vo);

		// 3. 응답 화면 구성
		model.addAttribute("board", board);
		
		return "getBoard.jsp";
	}
	
	// 검색 조건 목록 설정
	// @RequestMapiing 어노테이션이 적용된 메소드보다 먼저 호출됨
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new LinkedHashMap<>();
		
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		
		return conditionMap;
	}
	
	// 게시글 목록 조회
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo,	Model model) {
		if (vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if (vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		
		System.out.println("검색 조건: " + vo.getSearchCondition());
		System.out.println("검색 단어: " + vo.getSearchKeyword());
		
		// 2. DB 연동 처리
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		// 3. 응답 화면 구성
		model.addAttribute("boardList", boardList);
		
		return "getBoardList.jsp";
	}
	
	@RequestMapping(value="dataTransform.do")
	@ResponseBody
	public List<BoardVO> dataTransform(BoardVO vo) {
		if (vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if (vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		
		System.out.println("검색 조건: " + vo.getSearchCondition());
		System.out.println("검색 단어: " + vo.getSearchKeyword());
		
		// 2. DB 연동 처리
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		return boardList;
	}
	
	@RequestMapping(value="dataTransform_xml.do")
	@ResponseBody
	public BoardListVO dataTransformXml(BoardVO vo) {
		if (vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if (vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		
		System.out.println("검색 조건: " + vo.getSearchCondition());
		System.out.println("검색 단어: " + vo.getSearchKeyword());
		
		// 2. DB 연동 처리
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(boardList);
		
		return boardListVO;
	}
}









