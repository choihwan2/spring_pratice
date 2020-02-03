package annotaion.aopexam;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnimalAspect {
	
	@Pointcut("execution (public * annotaion.aopexam.*.*(..))")
	public void eat() { };
	
	@Before("eat()")
	public void whatEat() {
		System.out.println("오늘 점심에 뭐 먹었어요?");
	}

	@AfterReturning(pointcut= "eat()", returning = "returning")
	public void afterEat(Object returning) {
		try {
			if (returning != null) {
				System.out.println(returning + "먹습니다");
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Around("eat()")
	public void aroundEat(ProceedingJoinPoint joinPoint) {
		try {
			System.out.println("오늘 점심에 뭐 먹었어요?");
			Object obj = joinPoint.proceed();
			System.out.println(obj + "먹었군요");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
