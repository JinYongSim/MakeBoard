package com.scit.MakeBoard.DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;

import com.scit.MakeBoard.VO.Board;

public interface BoardMapper {
	public int insertBoard(Board board);
	public ArrayList<Board> selectBoardList(RowBounds rb,String search);
	public Board selectBoardDetail(String boardSeq);
	public void updateBoard(Board board);
	public int deleteBoard(String boardSeq);
	public void increaseHitCount(String boardSeq); // 조회수 (hitCount)증가
	public int totalCount(String search);
}
