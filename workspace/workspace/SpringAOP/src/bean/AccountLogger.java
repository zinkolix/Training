package bean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class AccountLogger {

	public void logBefore(JoinPoint point) {
		System.out.println("Logging before execution of " + point.getSignature().getName());
	}
	
	public void logAfter(JoinPoint point){
		System.out.println("Logging after execution of " + point.getSignature().getName());
	}
	
	public void logAfterReturning(JoinPoint point, Object retVal){
		String method = point.getSignature().getName();
		System.out.println("Logging after returning of " + method + " returning " + retVal);
	}
	
	public void logAfterThrowing(JoinPoint point, Exception ex){
		String method = point.getSignature().getName();
		System.out.println("Logging after throwing of " + method + " throws " + ex.getMessage());
	}
	
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
