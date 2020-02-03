package tvspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//dependenct: 직접 객체 생성 --> 위임(다른 객체로부터 전달)
		//--> 위임(스프링)
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext
				("tvspring/tv.xml");
		
		TV tv = factory.getBean("tv", TV.class);	//xml 파일 안에서 id가 tv로 지정되어있는애를 TV.class 로 형변환해서 생성한다.
		
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();

	}

}
