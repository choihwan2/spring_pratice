package edu.multi.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO {
	
	@Autowired
	@Qualifier("sqlSession2")
	SqlSession session2;
	
	public int insertMember(MemberVO vo) {
		int i = session2.insert("newmember", vo);
		return i;
	}
	
	public MemberVO selectMemeber(String userid, String password) {
		MemberVO vo = new MemberVO();
		vo.setUserid(userid);
		vo.setPassword(password);
		vo = session2.selectOne("getmember", vo);
		return vo;
	}
}
