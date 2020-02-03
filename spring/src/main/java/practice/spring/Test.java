package practice.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("practice/spring/test.xml");

		TestService service = factory.getBean("serviceTest", TestService.class);
		TestVO vo = service.test();
		System.out.println(vo.getMember1() + " : " + vo.getMember2());

	}
}
