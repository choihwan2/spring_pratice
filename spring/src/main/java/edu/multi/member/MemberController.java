package edu.multi.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@Autowired
	MemberDAO dao;
	
	@RequestMapping(value = "/member/insertmember", method = RequestMethod.GET)
	public String insertMember() {

		return "/member/insertmember";
	}
	
	@RequestMapping(value = "/member/insertmember", method = RequestMethod.POST)
	public ModelAndView insertMember(MemberVO vo) {
		ModelAndView mv = new ModelAndView();
		try {
			dao.insertMember(vo);
			mv.setViewName("/member/login");
		} catch (Exception e) {
			mv.setViewName("/member/inserterror");
		}

		return mv;
	}

}
