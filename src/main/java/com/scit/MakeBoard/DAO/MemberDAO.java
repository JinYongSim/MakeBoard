package com.scit.MakeBoard.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scit.MakeBoard.VO.Member;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int insertMember(Member member) {
		int result = 0;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		try {
			result = mapper.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원가입 오류");
		}
		
		return result;
	}
}
