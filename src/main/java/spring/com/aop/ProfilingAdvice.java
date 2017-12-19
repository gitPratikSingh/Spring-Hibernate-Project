package spring.com.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.util.StopWatch;

public class ProfilingAdvice implements MethodInterceptor{

	public static void main(String[] args) {
		WorkerBean workerBean = getWorkerBean();
		workerBean.doSomeWork(1000000);
		workerBean.doSomeWork(10000000);
		workerBean.doWork();
	}
	
	static WorkerBean getWorkerBean() {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(new WorkerBean());
		pf.addAdvice(new ProfilingAdvice());
		
		return (WorkerBean)pf.getProxy();
	}

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(mi.getMethod().getName());
		Object retVal = mi.proceed();
		sw.stop();
		dumpInfo(mi, sw.getTotalTimeMillis());
		return retVal;
	}

	private void dumpInfo(MethodInvocation mi, long totalTimeMillis) {
		Method method = mi.getMethod();
		Object target = mi.getThis();
		Object[] arguments = mi.getArguments();
		
		System.out.println("Method called: "+method.getName());
		System.out.println("Target: "+target.getClass().getName());
		
		for(int i=0; i<arguments.length; i++) {
			System.out.print("Arguments: "+ arguments[i]);
		}
		
		System.out.println("\nTook(ms):"+totalTimeMillis);
		
		
	}

}
