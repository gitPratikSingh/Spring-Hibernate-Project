package spring.com.aop.pointcuts;

import java.lang.reflect.Method;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class StaticPointcut extends StaticMethodMatcherPointcut{
	//use the pointcut to instruct the Spring where to apply the advice 
	
	@Override
	public boolean matches(Method method, Class<?> cls) {
		return method.getName().equals("sing");
	}
	
	@Override
	public ClassFilter getClassFilter() {
		return (new ClassFilter() {
			public boolean matches(Class <?> cls) {
				return cls == Target.class;
			}
		});
	}
	
	public static void main(String args[]) {
		
		Target tg = new Target();
		Advice advice = new SimpleAdvice();
		Pointcut pc = new StaticPointcut();
		Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(tg);
		tg = (Target)pf.getProxy();
		tg.sing();
		
		
		AnotherTarget atg = new AnotherTarget();
		
		ProxyFactory npf = new ProxyFactory();
		npf.addAdvisor(advisor);
		npf.setTarget(atg);
		atg = (AnotherTarget)npf.getProxy();
		atg.sing();
	}
}
