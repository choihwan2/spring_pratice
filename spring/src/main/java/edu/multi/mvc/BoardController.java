package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	@Autowired
	BoardDAO dao;

	@RequestMapping("/board")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardController 실행중입니다.");
		
		ModelAndView mv = new ModelAndView();
		
		//servlet ---> jsp 데이터 전달 = 공유 == Model
		mv.addObject("board",dao.getList()); // request.setAttribute()
		mv.setViewName("board"); //view 세팅
		return mv;
	}


}
