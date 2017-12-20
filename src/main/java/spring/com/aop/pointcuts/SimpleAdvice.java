package spring.com.aop.pointcuts;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		System.out.println(">> Invoking :"+mi.getMethod().getName());
		Object retVal = mi.proceed();
		System.out.println("\nDone!<<");
		return retVal;
	}

}
