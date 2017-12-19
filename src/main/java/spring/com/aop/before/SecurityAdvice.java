package spring.com.aop.before;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SecurityAdvice implements MethodBeforeAdvice{

	SecurityManager securityManager; 
	SecurityAdvice(){
		securityManager = new SecurityManager();
	}
	
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		
		// check security
		if(securityManager.getLoggedOnUser().userName.equals("John")) {
			System.out.println("Authenticated!");
		}else {
			throw new SecurityException("Not autehnticated!");
		}
		
	}
	
	
	static SecureBean getSecureBean() {
		// return a weaved secureBean// proxy securebean
		
		SecureBean target = new SecureBean();
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvice(new SecurityAdvice());
		
		SecureBean proxy = (SecureBean)pf.getProxy();
		return proxy;
		
	}
	
	
	public static void main(String args[]) {
		
		SecurityManager securityManager = new SecurityManager();
		securityManager.login("John", "Cena");
	
		SecureBean secureBean = getSecureBean();
		secureBean.WriteSecureMessage();
		
		securityManager.logout();
	}
	
}
