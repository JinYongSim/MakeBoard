package com.scit.MakeBoard;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scit.MakeBoard.DAO.BoardDAO;
import com.scit.MakeBoard.VO.Board;

@Controller
public class BoardController {
	@Autowired
	BoardDAO dao;
	
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public String board() {
		return "boardWrite";
	}
	
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(Board board, HttpSession session) {
		int result = 0;
		board.setId((String) session.getAttribute("loginId"));
		
		System.out.println(board);
		result = dao.insertBoard(board);
		if(result == 0) {
			return "boardWrite";
		}
		else {
			return "redirect:/selectBoardList";
		}
	}
	
	@RequestMapping(value="/selectBoardList", method=RequestMethod.GET)
	public String selectBoardList(Model model) {
		ArrayList<Board> list = new ArrayList<Board>();
		list = dao.selectBoardList();
		model.addAttribute("boardList", list);
		return "board";
	}
}
