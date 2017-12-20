package spring.com.aop.pointcuts;

import java.lang.reflect.Method;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class DynamicPointcut extends DynamicMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> cls, Object... args) {
		int x = (int)args[0];
		return (x!=100 && args.length==1);
	}
	
	@Override
	public boolean matches(Method method, Class<?> cls) {
		return (method.getName().equals("printNumber"));
	}
	
	public ClassFilter getClassFilter() {
		return (new ClassFilter() {

			@Override
			public boolean matches(Class<?> cls) {
				return cls == Target.class;
			}
			
		});
	}
	
	public static void main(String args[]) {
		Advice advice = new SimpleAdvice();
		Pointcut pc = new DynamicPointcut();
		Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(new Target());
		
		Target proxy = (Target)pf.getProxy();
		proxy.sing();
		proxy.printNumber(1);// advised
		proxy.printNumber(100);
		proxy.printNumber(10);// advised
		proxy.printNumber(10,10);
		
	}
}
