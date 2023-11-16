package com.ezen.biz.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.BoardVO;

//@Repository
public class BoardDAO extends SqlSessionDaoSupport {
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	// �Խñ� �ۼ�
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC�� insertBoard() ó��");
		
		getSqlSession().insert("BoardMapper.insertBoard", vo);
	}
	
	// �Խñ� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC�� updateBoard() ó��");
		
		getSqlSession().update("BoardMapper.updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC�� deleteBoard() ó��");
		
		getSqlSession().delete("BoardMapper.deleteBoard",vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC�� getBoard() ó��");
		
		return getSqlSession().selectOne("BoardMapper.getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC�� getBoardList() ó��");
		
		return getSqlSession().selectList("BoardMapper.getBoardList_D", vo);
	}

}
















