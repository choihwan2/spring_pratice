package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController{
	
	@RequestMapping("/hello") //<beans:prop key = "/hello">hc<beans:prop>
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("HelloController 실행중입니다.");
		
		ModelAndView mv = new ModelAndView();
		//servlet ---> jsp 데이터 전달 = 공유 == Model
		mv.addObject("model","Hello Spring(어노테이션)"); // request.setAttribute()
		mv.setViewName("hello"); //view 세팅 없으면 annotaion과 같은 이름으로 만들어줌.
		return mv;
	}

}
