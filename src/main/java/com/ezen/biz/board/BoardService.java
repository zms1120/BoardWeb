package com.ezen.biz.board;

import java.util.List;

import com.ezen.biz.dto.BoardVO;

public interface BoardService {

	// �Խñ� �ۼ�
	void insertBoard(BoardVO vo);

	// �Խñ� ����
	void updateBoard(BoardVO vo);

	void deleteBoard(BoardVO vo);

	BoardVO getBoard(BoardVO vo);

	List<BoardVO> getBoardList(BoardVO vo);

}