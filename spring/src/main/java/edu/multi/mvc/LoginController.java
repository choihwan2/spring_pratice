package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(name = "/login", method = RequestMethod.GET)
	// 1. Request매핑 메소드 리턴타입 String
	// 뷰이름으로 되는 규칙이 있음. 모델은 필요없고 뷰의 이름만 필요할때는 이렇게 사용하는게 좋다
	public String loginform() {

		// 로그인폼 출력

		return "loginform";
	}

	@RequestMapping(name = "/login", method = RequestMethod.POST)
	public ModelAndView loginSuccess(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginresult", true);
		mv.setViewName("loginsuccess");
		return mv;
	}
}
