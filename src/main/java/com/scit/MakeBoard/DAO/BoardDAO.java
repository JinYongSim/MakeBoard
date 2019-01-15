package com.scit.MakeBoard.DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

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
	
	public ArrayList<Board> selectBoardList(){
		ArrayList<Board> list = new ArrayList<Board>();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		list = mapper.selectBoardList();
		return list;
	}
	
	public Board selectBoardDetail(String boardSeq) {
		Board boardDetail = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		System.out.println("확인" + boardSeq);
		try {
			boardDetail = mapper.selectBoardDetail(boardSeq);
			
		} catch (Exception e) {
			e.printStackTrace();
			return boardDetail;
		}
		return boardDetail;
	}
	
}
