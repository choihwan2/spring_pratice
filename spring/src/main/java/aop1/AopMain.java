package aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("aop1/aop.xml");
		Member m = factory.getBean("member", Member.class);
		Board b = factory.getBean("board", Board.class);
		
		//공통관심 = 횡당관심 = aspect클래스
		//Common c = factory.getBean("common", Common.class);

		//호출 시간
		m.login("spring");
		//호출시간
		b.insertBoard(100);
		//호출시간
		b.getList();
		//호출시간
		m.logout();
	}

}
