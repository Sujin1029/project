package namoo.springjpa.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BasicAspect {
	
	/** Pointcut 종류 : @Before(), @After(), @AfterReturnning(), @AfterThrowing(), @Around() */
	
	@Before("execution(* namoo.springjpa.service..*(..))")
	public void startLog() {
	System.out.println("===== 비즈니스 메소드 실행 전 =====");
	}
	@After("execution(* namoo.springjpa.service..*(..))")
	public void endLog() {
	System.out.println("===== 비즈니스 메소드 실행 후 =====");
	}
	// 리턴값 (호출기능 없음)
	@AfterReturning(pointcut = "execution(* namoo.springjpa.service..*(..))", returning = "returnValue")
	public void afterReturningLog(JoinPoint joinPoint, Object returnValue) {
	System.out.println(">> 실행 메소드 반환값: " + returnValue);
	}
	// 예외 발생
	@AfterThrowing(pointcut = "execution(* namoo.springjpa.service..*(..))", throwing = "exception")
	public void afterThrowingLog(JoinPoint joinPoint, Throwable exception) {
	System.out.println(">> " + joinPoint.getSignature().toShortString() + " 메소드 예외발생 : " + exception);
	}
	// 어라운드는 proceed 호출 가능함 
}
