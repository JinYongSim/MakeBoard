package com.scit.MakeBoard;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scit.MakeBoard.DAO.MemberDAO;
import com.scit.MakeBoard.VO.Member;

@Controller
public class LoginController {
	@Autowired
	MemberDAO dao;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/loginMember", method=RequestMethod.POST)
	public String loginMember(Member member, HttpSession session) {
		Member l_Member = dao.loginMember(member);
		if(l_Member == null) {
			return "login";
		}
		else {
			session.setAttribute("loginId", member.getId()); // 세션에 loginId라는 변수로 member 객체를 저장, 나중에 쓸곳이 많다.
			return "redirect:/selectBoardList";
		}
		
	}
}
