package service.spring2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("service/spring2/product.xml");

		ProductService service = factory.getBean("service", ProductService.class);
		ProductVO vo = service.sell();
		System.out.println(vo);

		ProductService service2 = factory.getBean("service2", ProductService.class);
		service2.sell();
		System.out.println(vo);

		ProductService service3 = factory.getBean("service3", ProductService.class);
		service3.sell();
		System.out.println(vo);
	}

}
