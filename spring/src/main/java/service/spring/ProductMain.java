package service.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("service/spring/product.xml");

		ProductService service = factory.getBean("service", ProductService.class);
		ProductVO vo = service.sell();
		System.out.println(vo);
	}

}
