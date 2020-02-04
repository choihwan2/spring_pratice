package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class BoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardController 실행중입니다.");
		
		ModelAndView mv = new ModelAndView();
		BoardDAO dao = new BoardDAO();
		
		//servlet ---> jsp 데이터 전달 = 공유 == Model
		mv.addObject("board",dao.getList()); // request.setAttribute()
		mv.setViewName("board"); //view 세팅
		return mv;
	}

}
