package edu.multi.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	@Autowired
	BoardDAO dao;

	@RequestMapping("/board")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardController 실행중입니다.");

		ModelAndView mv = new ModelAndView();

		// servlet ---> jsp 데이터 전달 = 공유 == Model
		mv.addObject("board", dao.getList()); // request.setAttribute()
		mv.setViewName("board"); // view 세팅
		return mv;
	}
	// 1개 게시물 저장 게시물 글쓰기 폼 화면
	@RequestMapping(value = "/boardinsert", method = RequestMethod.GET)
	public String insertBoardForm() {
		return "boardinsertform";
	}

	//글쓴 내용 전달받아서 board 테이블 저장
	@RequestMapping(value = "/boardinsert", method = RequestMethod.POST)
	public String insertBoardResult(@ModelAttribute("vo")BoardVO vo) {
		int result = dao.insertBoard(vo);
		if(result == 1) {
			System.out.println("정상 insert");
		}else {
			System.out.println("비정상 insert");
		}
		return "redirect:/board";
	}

	// 글번호 입력 받아서 게시물 조회
	@RequestMapping("/boardselect")
	public ModelAndView selectBoardSEQ(int seq) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("selectboard", dao.getOneBoard(seq));
		return mv;
	}

	// 1개 게시물 수정
	@RequestMapping("/boardupdate")
	public String updateBoard(BoardVO vo) {
		dao.updateBoard(vo);
		return "redirect:/board";
	}
	
	// 1개 게시물 삭제
	@RequestMapping(value = "/boarddelete", method = RequestMethod.POST)
	public String deleteBoard(int seq, int password) {
		dao.deleteBoard(seq,password);
		return "redirect:/board";
	}

}
