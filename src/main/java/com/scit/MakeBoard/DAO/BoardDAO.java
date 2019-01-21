package com.scit.MakeBoard.DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scit.MakeBoard.PageNavigator.PageNavigator;
import com.scit.MakeBoard.VO.Board;

@Repository
public class BoardDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int insertBoard(Board board) {
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.insertBoard(board);
		} catch (Exception e) {
			
			System.out.println("게시물 등록 오류");
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Board> selectBoardList(PageNavigator pn){
		ArrayList<Board> list = new ArrayList<Board>();
		RowBounds rb=new RowBounds(pn.getStartBoardPage(),pn.getBoardPerPage());
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			list = mapper.selectBoardList(rb);
		} catch (Exception e) {
			return null;
		}
		
		return list;
	}
	
	public Board selectBoardDetail(String boardSeq) {
		Board boardDetail = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			boardDetail = mapper.selectBoardDetail(boardSeq);
			
		} catch (Exception e) {
			e.printStackTrace();
			return boardDetail;
		}
		return boardDetail;
	}
	
	public int deleteBoard(String boardSeq) {
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.deleteBoard(boardSeq);
		} catch (Exception e) {
			System.out.println("삭제실패");
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void increaseHitCount(String boardSeq) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.increaseHitCount(boardSeq);
	}
	
	public int totalCount() {
		int result=0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result=mapper.totalCount();
		} catch (Exception e) {
			return 0;
		}
		
		
		return result;
	}
	
}
