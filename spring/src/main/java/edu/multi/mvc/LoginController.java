package edu.multi.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	// 1. Request매핑 메소드 리턴타입 String
	// 뷰이름으로 되는 규칙이 있음. 모델은 필요없고 뷰의 이름만 필요할때는 이렇게 사용하는게 좋다
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginform() {

		// 로그인폼 출력

		return "loginform";
	}

//	@RequestMapping(name = "/login", method = RequestMethod.POST)
//	public ModelAndView loginSuccess(HttpServletRequest request) {
//		//POST방식으 한글이 깨진다. web.xml로 가서 설정을 해주자 AOP방식으로도 가능한데 xml 설정으로 해결가능
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		ModelAndView mv = new ModelAndView();
//		if (id.equalsIgnoreCase("spring") && pw.equals("spring")) {
//			mv.addObject("loginresult", true);
//		} else {
//			mv.addObject("loginresult", false);
//		}
//		mv.setViewName("loginsuccess");
//		return mv;
//	}

//	@RequestMapping(name = "/login", method = RequestMethod.POST)
//	public ModelAndView loginSuccess(@RequestParam(value = "id", required = false, defaultValue = "spring") String id2,
//			String pw, int age) { // @RequestParam("id")라고 써있는 부분 = > id2 에 자동 저장되게 해줌.
//		// form input name = "id" : 요청파라미터이름이 id인 것으로 전송한다.
//		// 요청 파라미터이름과 컨트롤러 메소드 매개변수 이름이 동일하면 자동으로 저장된다.
//		// form 입력 name 값 = 매개변수이름 동일 = db 컬럼명과 동일 하게 만들어서 저장하면 매우 단순해지고 좋음.
//		ModelAndView mv = new ModelAndView();
//		if (id2.equalsIgnoreCase("spring") && pw.equals("spring")) {
//			mv.addObject("loginresult", true);
//		} else {
//			mv.addObject("loginresult", false);
//		}
//		mv.setViewName("loginsuccess");
//		return mv;
//	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginSuccess(@ModelAttribute("login")LoginVO vo) {
		// 요청 파라미터이름과 컨트롤러 메소드 매개변수가 객체일 떄 객체 내부 멤버 변수가 이름이 동일하면 자동 저장.
		
	    //컨트롤러 메소드 매개변수 객체일 때 자동 모델로 사용가능하다
	    // 모델 이름 자동 결정이 된다: 앞글자 소문자로 만들고 사용 가능 
	    // 즉 mv.addObject("loginVO",vo);  라고 써준것과 같은 효과가 적용됨.
	    //ex)loginVO
		ModelAndView mv = new ModelAndView();
		if (vo.getId().equalsIgnoreCase("spring") && vo.getPw().equals("spring")) {
			mv.addObject("loginresult", true);
		} else {
			mv.addObject("loginresult", false);
		}
		mv.setViewName("loginsuccess");
		return mv;
	}
}
