package aopexam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("aopexam/animal.xml");
		Animal[] ani = new Animal[3];
		ani[0] = factory.getBean("cat", Animal.class);
		ani[1] = factory.getBean("dog", Animal.class);
		ani[2] = factory.getBean("rabbit", Animal.class);

		
		for (Animal animal : ani) {
			animal.lunch();
		}
	}

}
