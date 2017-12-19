package spring.com.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleThrowsAdvice implements ThrowsAdvice{

	public static void main(String[] args) {
		
		ErrorBean errorBean = new ErrorBean();
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(errorBean);
		pf.addAdvice(new SimpleThrowsAdvice());
		
		errorBean = (ErrorBean) pf.getProxy();
		try{
			errorBean.errorProneMethod();
		}catch(Exception ignoreException) {}
		
		try{
			errorBean.anotherErrorProneMethod();
		}catch(IllegalArgumentException ignoreException) {}
	}
	
	public void afterThrowing(Exception e) throws Throwable{
		System.out.println("***");
		System.out.println("Exception Capture");
		System.out.println("Caught: " + e.getClass().getName());
		System.out.println("***\n");
	}
	
	public void afterThrowing(Method method, Object args, Object target,
		IllegalArgumentException ex) throws Throwable {
		System.out.println("***");
		System.out.println("IllegalArgumentException Capture");
		System.out.println("Caught: " + ex.getClass().getName());
		System.out.println("Method: " + method.getName());
		System.out.println("***\n");
	}
}
