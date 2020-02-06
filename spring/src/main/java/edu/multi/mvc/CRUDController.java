package edu.multi.mvc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CRUDController {
	
	Map<String,String> members = new HashMap<String,String>();
	
	@RequestMapping("/crud/start")
	public String start(){
		System.out.println("====홈페이지 첫화면 입니다====");
		members.put("spring", "최환");
		members.put("oracle", "박대리");
		members.put("mybatis", "최과장");
		return "crud/start";
	}
	
	@RequestMapping("/crud/list")
	public ModelAndView list(){
		//Model = 컨트롤러에서 jsp로 전달해서 출력해줄 데이터
		ModelAndView mv = new ModelAndView();
		mv.addObject("members",members);
		//뷰이름이 명시하지 않다면 자동으로 url과 똑같은 이름으로 view가 만들어진다. 위에 return 과 같음.
		return mv;
		//모든 회원정보
		
	}
	
	@RequestMapping("/crud/get")
	public ModelAndView get(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = members.get(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", id + ":" + name);
		return mv;
	}
	
	@RequestMapping("/crud/add")
	public void add(){
		members.put("new", "신입사원");
	}
	
	@RequestMapping("/crud/delete")
	public String delete() {
		members.remove("new");
		return "redirect:/crud/list";
		//redirect면 매핑되어있던 컨트롤러에 /crud/ist 라고 매핑되어있는 메소드를 실행하는것 뷰를 보여주는것이 아니다.
		//없다면 
	}
	
	@RequestMapping("/crud/update")
	public Map<String,String> update(){
		Map<String, String> informs = new HashMap<String, String>();
		informs.put("id","수정할 id를 입력하세요");
		informs.put("name","수정할 이름을 입력하세요");
		informs.put("email","이메일양식은 xxx@yyy.com입니다");
		informs.put("idvalue","spring");
		return informs; //자동 3개 Model
		//뷰이름 자동 ../crud/update.jsp
	}
}
