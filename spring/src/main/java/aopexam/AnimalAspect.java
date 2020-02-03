package aopexam;

import org.aspectj.lang.ProceedingJoinPoint;

public class AnimalAspect {
	
	public void whatEat() {
		System.out.println("오늘 점심에 뭐 먹었어요?");
	}

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
