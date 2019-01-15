package com.scit.MakeBoard.DAO;

import java.util.ArrayList;

import com.scit.MakeBoard.VO.Board;

public interface BoardMapper {
	public int insertBoard(Board board);
	public ArrayList<Board> selectBoardList();
}
