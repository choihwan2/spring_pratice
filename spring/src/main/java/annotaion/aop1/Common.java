package annotaion.aop1;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component //<bean id = "common class = "Common"/>
@Aspect //<aop:aspect id= "c" ref= "common"/>
public class Common {
	long startTime;
	
	@Pointcut("execution (public * annotaion.aop1.*.*(..))") //<aop:pointcut expression = "execution (public * annotaion.aop1.*.*(..))" id = "pc">
	public void pc() { }
	
	@Before("pc()") // <aop:before method = "a" ref-pointcut="pc">
	public void a() { //before
		startTime = System.currentTimeMillis();
		System.out.println("===메소드 호출시각=== " + new Date(startTime));
	}
	
//	@After("pc()")
	public void b() { //after
		long endTime = System.currentTimeMillis();
		System.out.println("===메소드 실행 소요시간(1/1000초)===" + (endTime - startTime));
	}
	
//	@Around("pc()")
	public void c(ProceedingJoinPoint joinPoint) { //around = before + after
		try {
			System.out.println("메소드 수행이전");
			Object returnValue = joinPoint.proceed(); //pointcut 문법 선택 핵심관심 메소드 수행
			System.out.println("returnValue = " + returnValue);
			
			System.out.println("getTarget() = " + joinPoint.getTarget());
			System.out.println("getArgs() = " + joinPoint.getArgs());
			System.out.println("toLongString() = " + joinPoint.toLongString());
			
			
			System.out.println("메소드 수행이후");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
