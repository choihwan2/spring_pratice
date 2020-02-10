package edu.multi.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.multi.mybatis.EmpDAO;

@Controller
public class EmpController {

//	@Autowired
	EmpDAO dao;

	@RequestMapping("/mybatis/emplist")
	public ModelAndView getAllEmp() {
		// employess 테이블 모든 레코드 조회
		// List<EmpVO>--MODEL
		// view 결정
		List<EmpVO> list = dao.getAllEmp();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("/mybatis/detailemp")
	public ModelAndView getOneEmp(int employee_id) {
		EmpVO vo = dao.getOneEmp(employee_id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("emp", vo);
		return mv;
	}

	@RequestMapping("/mybatis/ajaxdetailemp")
	@ResponseBody // 모든 객체 -- JSON 형식 변경
	public EmpVO ajaxgetOneEmp(int employee_id) {
		// boarddetail?seq=1
		EmpVO vo = dao.getOneEmp(employee_id);
		return vo;
	}

	// employess 테이블 존재 레코드 갯수 페이지 번호 생성
	// 1. select count(*) from employess
	@RequestMapping("/mybatis/pagingemplist")
	public ModelAndView getCntEmp() {
		int count = dao.getCountEmp();
		int cntPerPage = 10;
		int totalPage = 0;
		if (count % cntPerPage == 0) {
			totalPage = count / cntPerPage;
		} else {
			totalPage = count / cntPerPage + 1;
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("totalPage", totalPage);
		return mv;
	}
	
	@RequestMapping("/mybatis/pagingemplist2")
	public ModelAndView getPagingEmpList(int pagenum) {
		int cntPerPage = 10;
		int start = (pagenum-1) * cntPerPage + 1;
		int end = pagenum * cntPerPage;
		int param [] = {start,end};
		List<EmpVO> paginglist = dao.pagingEmp(param);
		ModelAndView mv = new ModelAndView();
		mv.addObject("paginglist", paginglist);
		return mv;
	}


}
