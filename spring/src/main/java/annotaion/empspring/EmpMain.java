package annotaion.empspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotaion/empspring/emp.xml");
		// Spring bean configuration xml

		//스프링 xml 설정 내용 객체 생성 :1개 공유 : singleton 방식으로 생성합니다.
		EmpDAO dao = factory.getBean("dao", EmpDAO.class);
		dao.insertEmp();
	}

}
