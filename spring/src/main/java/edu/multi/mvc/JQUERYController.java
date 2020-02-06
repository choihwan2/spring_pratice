package edu.multi.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JQUERYController {
	
	@Autowired
	BoardDAO dao;

	@RequestMapping("/jquerytest")
	public String jquerytest() {
		return "jquery";
	}

	@RequestMapping("/ajaxtest")
	public String ajaxtest() {
		return "ajax";
	}

	@RequestMapping("/ajaxlogin")
	public String ajaxtestlogin(String id, String pw) {
//		if(id.equals("ajax") && pw.equals("ajax")) {
//			
//		}
		return "ajaxsuccess";
	}
	
	//AJAX요청 처리 응답시 강제적으로 한글인코딩을 UTF-8로 설정해주세요 = proudces!
	@RequestMapping(value = "/ajaxlogin2" , produces = {"application/json; charset=UTF-8"})
	@ResponseBody //지금의 body를 바꾸지 않고 업데이트! 반드시 json 으로 보내줘야한다.
	public String ajaxlogin2(String id, String pw) {
		boolean status = false;
		String logintime = "---";
		if (id.equals("ajax") && pw.equals("ajax")) {
			status = true;
			logintime = new java.util.Date().toLocaleString();
		}
		return "{\"status\" :" + status + ",\"time\":\"" +logintime + "\"}";
	}
	
	@RequestMapping("/ajaxboard")
	@ResponseBody // 모든 객체 -- JSON 형식 변경
	public BoardVO ajaxBoard(int seq){
		//boarddetail?seq=1
		BoardVO vo = dao.getOneBoard(seq);
		return vo;
	}

}
