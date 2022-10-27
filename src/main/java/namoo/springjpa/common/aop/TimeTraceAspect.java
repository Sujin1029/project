package namoo.springjpa.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 공통 관심(로직) 기능 정의
@Component		// 빈으로 등록할때 사용
@Aspect			// 공통기능 알려주기
public class TimeTraceAspect {
	// 적용할 Advice 정의 
	@Around("execution(* namoo.springjpa..*(..))")	// 포인트컷
	// *은 모든 클래스의 모든 메소드 / ..은 모든 패키지(메소드 등)
	public Object methodTimeTrace(ProceedingJoinPoint joinPoint) throws Throwable {	
		// 현재 시간 가져오기 (공통작업 등록)
		long start = System.currentTimeMillis();
		String bizObject = joinPoint.getTarget().getClass().getName();	// 비즈니스 로직 실행되기 전에 어떤 비즈니스 객체가 실행되는지 알기
		String bizMethod = joinPoint.getSignature().toShortString();
		System.out.println("----- "+ bizObject + " 객체의 "+ bizMethod + " 메소드 START -----");
		//실제 비즈니스 객체의 메소드 호출
		try {
			return joinPoint.proceed();
		} finally {
			long finish = System.currentTimeMillis();
			long timeMS = finish - start;	//시간
			System.out.println("실행시간 " + timeMS + "ms");
			System.out.println("----- "+ bizObject + " 객체의 "+ bizMethod + " 메소드 FINISH -----");
		}
	}
}
