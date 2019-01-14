package com.scit.MakeBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scit.MakeBoard.DAO.MemberDAO;

@Controller
public class MemberController {
	@Autowired
	MemberDAO dao;
	
	@RequestMapping(value="/signUp", method=RequestMethod.GET)
	public String signUp() {
		return "signUp";
	}
		
}
