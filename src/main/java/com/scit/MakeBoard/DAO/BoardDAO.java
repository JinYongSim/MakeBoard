package com.scit.MakeBoard.DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scit.MakeBoard.PageNavigator.PageNavigator;
import com.scit.MakeBoard.VO.Board;
import com.scit.MakeBoard.VO.Comment;

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
	
	public ArrayList<Board> selectBoardList(PageNavigator pn,String search){
		ArrayList<Board> list = new ArrayList<Board>();
		RowBounds rb=new RowBounds(pn.getStartBoardPage(),pn.getBoardPerPage()); // startBoardPage 현재페이지의 첫글 위치
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);			 // boardPerPage 페이지당 글의 갯수
		try {
			list = mapper.selectBoardList(rb,search);
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
	
	public void updateBoard(Board board) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			mapper.updateBoard(board);
		} catch (Exception e) {
			System.out.println("업데이트 에러");
		}
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
	
	public int totalCount(String search) {
		int result=0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result=mapper.totalCount(search);
		} catch (Exception e) {
			return 0;
		}
		
		
		return result;
	}
	
	// 댓글 등록
	public int insertComment(Comment comment) {
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.insertComment(comment);
		} catch (Exception e) {
			System.out.println("댓글 등록 에러");
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Comment> selectComment(String boardSeq){
		ArrayList<Comment> cList = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			cList = mapper.selectComment(boardSeq);
		} catch (Exception e) {
			System.out.println("댓글리스트 불러오기 에러");
			e.printStackTrace();
		}
		return cList;
	}
	
	public void deleteComment(String commentSeq) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try {
			mapper.deleteComment(commentSeq);
			System.out.println(commentSeq);
		} catch (Exception e) {
			System.out.println("댓글삭제에러");
			e.printStackTrace();
		}
	}
} // DAO 끝
