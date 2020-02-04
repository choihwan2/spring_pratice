package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("HelloController 실행중입니다.");
		
		ModelAndView mv = new ModelAndView();
		//servlet ---> jsp 데이터 전달 = 공유 == Model
		mv.addObject("model","Hello Spring"); // request.setAttribute()
		mv.setViewName("hello"); //view 세팅
		return mv;
	}

}
