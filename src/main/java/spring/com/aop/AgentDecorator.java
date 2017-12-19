package spring.com.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

public class AgentDecorator implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("James");
		Object returnVal = methodInvocation.proceed();
		System.out.println("!");
		return returnVal;
	}
	
	public static void main(String args[]) {
		
		Agent agent = new Agent();
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(agent);
		pf.addAdvice(new AgentDecorator());
		
		Agent proxy = (Agent)pf.getProxy();
		proxy.speak();
	}
}
