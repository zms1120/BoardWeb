package com.ezen.biz.dao;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.BoardVO;

@Repository
public class BoardDAO2 {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	// �Խñ� �ۼ�
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC�� insertBoard() ó��2");
		
		mybatis.insert("BoardMapper.insertBoard", vo);
	}
	
	// �Խñ� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC�� updateBoard() ó��2");
		
		mybatis.update("BoardMapper.updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC�� deleteBoard() ó��2");
		
		mybatis.delete("BoardMapper.deleteBoard",vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC�� getBoard() ó��2");
		
		return mybatis.selectOne("BoardMapper.getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC�� getBoardList() ó��2");
		
		return mybatis.selectList("BoardMapper.getBoardList_D", vo);
	}

}
















