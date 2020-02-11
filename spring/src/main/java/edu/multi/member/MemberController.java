package edu.multi.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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

		return "member/insertmember";
	}

	@RequestMapping(value = "/member/insertmember", method = RequestMethod.POST)
	public ModelAndView insertMember(MemberVO vo) {
		ModelAndView mv = new ModelAndView();
		try {
			dao.insertMember(vo);
			mv.setViewName("/member/login");
		} catch (DuplicateKeyException e) {
			mv.setViewName("/member/inserterror");
		}

		return mv;
	}

	@RequestMapping("/member/login")
	public String login() {
		return "member/login";
	}

	@RequestMapping(value = "/member/loginprocess", method = RequestMethod.POST)
	public String loginprocess(HttpServletRequest request, String userid, String password) {
		// ModelAndView mv = new ModelAndView();
		MemberVO vo = dao.selectMemeber(userid, password);
		HttpSession session = request.getSession();
		session.setAttribute("member", vo);
		// mv.addObject("member", vo);
		return "member/loginprocess";
	}

	@RequestMapping("/member/mypage")
	public String getMyPage() {
		return "member/mypage";
	}

	@RequestMapping("/member/logout")
	public String logout(HttpSession session) {
//		session.removeAttribute("member");
		return "member/logout";
	}

}
