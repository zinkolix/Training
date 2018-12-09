package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AccountLogger {

	@Before("execution(* deposit(..))")
	public void logBefore(JoinPoint point) {
		System.out.println("Logging before execution of " + point.getSignature().getName());
	}
	
	@After("execution(void summary())")
	public void logAfter(JoinPoint point){
		System.out.println("Logging after execution of " + point.getSignature().getName());
	}
	
	@AfterReturning(pointcut="execution(* get*())",returning="retVal")
	public void logAfterReturning(JoinPoint point, Object retVal){
		String method = point.getSignature().getName();
		System.out.println("Logging after returning of " + method + " returning " + retVal);
	}
	
	@AfterThrowing(pointcut="execution(* withdraw(..))", throwing="ex")
	public void logAfterThrowing(JoinPoint point, Exception ex){
		String method = point.getSignature().getName();
		System.out.println("Logging after throwing of " + method + " throws " + ex.getMessage());
	}
	
	@Around("execution(* *Transfer(..))")
	public Object logAround(ProceedingJoinPoint point) throws Throwable {
		// Code that executes pre-method execution
		String method = point.getSignature().getName();
		System.out.println("Logging before-around of " + method);
		
		Object retval = point.proceed();
		// Code that executes post-method execution
		System.out.println("Logging after-around of " + method);
		return retval;
	}
	
}
