package spring.com.aop;

import org.aspectj.lang.JoinPoint;

public class AOPAdvice {
	public void simpleBeforeAdvice(JoinPoint joinpoint) {
		System.out.println("Executing "+ joinpoint.getSignature().getDeclaringTypeName()+" "
				+ joinpoint.getSignature().getName());
	}
}
